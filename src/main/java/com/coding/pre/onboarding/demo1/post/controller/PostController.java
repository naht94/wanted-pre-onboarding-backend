package com.coding.pre.onboarding.demo1.post.controller;

import com.coding.pre.onboarding.demo1.exception.UnauthenticatedException;
import com.coding.pre.onboarding.demo1.exception.UserNotFoundException;
import com.coding.pre.onboarding.demo1.post.dto.*;
import com.coding.pre.onboarding.demo1.post.pageable.PageableRequest;
import com.coding.pre.onboarding.demo1.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PageableRequest pageableRequest;

    @PostMapping
    public ResponseEntity<Object> writePost(@RequestBody @Validated PostWriteRequest dto,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            String email = getEmail();
            PostWriteContent postWriteContent =
                    new PostWriteContent(dto.getTitle(), dto.getContents(), email);
            Long savedId = postService.writePost(postWriteContent);

            URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .replacePath("/api/posts/" + savedId)
                    .build()
                    .toUri();
            PostResponse responseDto = new PostResponse();
            responseDto.setId(savedId);
            return ResponseEntity.created(location).body(responseDto);
        } catch (UserNotFoundException e) {
            throw new UnauthenticatedException();
        }
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getPostsByPage(@RequestParam(required = false) Integer page) {
        Pageable pageable = pageableRequest.make(page);
        List<PostResponse> posts =  postService.getPostsByPage(pageable).stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable(name = "id") Long postId) {
        PostContent post = postService.getPost(postId);
        return ResponseEntity.ok(PostResponse.from(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long postId) {
        try {
            String email = getEmail();
            postService.deletePost(postId, email);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            throw new UnauthenticatedException();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> modifyPost(@PathVariable("id") Long postId,
                                                      @RequestBody @Validated ModifyPostRequest dto) {
        try {
            String email = getEmail();
            ModifyPostContent serviceDto =
                    new ModifyPostContent(postId, dto.getTitle(), dto.getContents(), email);

            postService.modifyPost(serviceDto);
            PostResponse postResponseDto = new PostResponse();
            postResponseDto.setId(postId);
            return ResponseEntity.ok().body(postResponseDto);
        } catch (UserNotFoundException e) {
            throw new UnauthenticatedException();
        }
    }

    private String getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetails) authentication.getPrincipal()).getUsername();
    }

}
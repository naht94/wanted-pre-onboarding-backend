package com.coding.pre.onboarding.demo1.post.service;

import com.coding.pre.onboarding.demo1.exception.PostNotFoundException;
import com.coding.pre.onboarding.demo1.exception.UnauthorizedException;
import com.coding.pre.onboarding.demo1.exception.UserNotFoundException;
import com.coding.pre.onboarding.demo1.post.dto.Board;
import com.coding.pre.onboarding.demo1.post.dto.ModifyPostContent;
import com.coding.pre.onboarding.demo1.post.dto.PostContent;
import com.coding.pre.onboarding.demo1.post.dto.PostWriteContent;
import com.coding.pre.onboarding.demo1.post.entity.Post;
import com.coding.pre.onboarding.demo1.post.repository.PostRepository;
import com.coding.pre.onboarding.demo1.user.entity.User;
import com.coding.pre.onboarding.demo1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Long writePost(PostWriteContent dto) {
        User writer = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(UserNotFoundException::new);

        Post post = Post.create(dto.getTitle(), dto.getContents(), writer);
        Post savedPost = postRepository.save(post);
        return savedPost.getId();
    }

    @Override
    public List<Board> getPostsByPage(Pageable pageable) {
        return postRepository.findAllPostBy(pageable);
    }

    @Override
    public PostContent getPost(Long postId) {
        return postRepository.findPostById(postId)
                .orElseThrow(PostNotFoundException::new);
    }

    @Override
    @Transactional
    public Long deletePost(Long postId, String email) {
        Post post = findAuthorizedUsersPost(postId, email);
        postRepository.delete(post);
        return post.getId();
    }

    @Override
    @Transactional
    public Long modifyPost(ModifyPostContent serviceDto) {
        Post post = findAuthorizedUsersPost(serviceDto.getPostId(), serviceDto.getEmail());
        post.changeTitleAndContents(serviceDto.getTitle(), serviceDto.getContents());
        return post.getId();
    }

    private Post findAuthorizedUsersPost(Long postId, String email) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        if (!post.writtenBy(email)) {
            throw new UnauthorizedException();
        }
        return post;
    }
}

package com.coding.pre.onboarding.demo1.user.controller;

import com.coding.pre.onboarding.demo1.user.dto.UserInfo;
import com.coding.pre.onboarding.demo1.user.dto.UserResponse;
import com.coding.pre.onboarding.demo1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getMember(@PathVariable(name = "id") Long userId) {
        UserInfo userInfo = userService.getUser(userId);
        return ResponseEntity.ok(UserResponse.getUser(userInfo));
    }
}

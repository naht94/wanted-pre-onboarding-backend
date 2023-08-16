package com.coding.pre.onboarding.demo1.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String email;

    public static UserResponse getUser(UserInfo userInfo) {
        return new UserResponse(userInfo.getId(), userInfo.getEmail());
    }
}

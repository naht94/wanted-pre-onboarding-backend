package com.coding.pre.onboarding.demo1.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModifyPostContent {
    private final Long postId;
    private final String title;
    private final String contents;
    private final String email;
}

package com.coding.pre.onboarding.demo1.post.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class PostWriteRequest {
    @NotBlank
    private final String title;
    @NotBlank
    private final String contents;
}

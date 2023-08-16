package com.coding.pre.onboarding.demo1.post.dto;

import java.time.LocalDateTime;

public interface PostContent {
    Long getId();

    String getTitle();

    String getContents();

    String getWriterEmail();

    LocalDateTime getUpdatedAt();
}

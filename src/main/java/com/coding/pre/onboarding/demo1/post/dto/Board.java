package com.coding.pre.onboarding.demo1.post.dto;

import java.time.LocalDateTime;

public interface Board {
    Long getId();
    String getTitle();
    String getWriterEmail();
    LocalDateTime getUpdatedAt();
}

package com.coding.pre.onboarding.demo1.user.dto;

import java.time.LocalDateTime;

public interface UserInfo {
    Long getId();
    String getEmail();

    LocalDateTime getUpdatedAt();
}

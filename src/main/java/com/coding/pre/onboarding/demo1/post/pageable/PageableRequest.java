package com.coding.pre.onboarding.demo1.post.pageable;

import org.springframework.data.domain.Pageable;

public interface PageableRequest {
    Pageable make(Integer page);
}

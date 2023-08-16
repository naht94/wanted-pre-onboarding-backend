package com.coding.pre.onboarding.demo1.post.pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PageableRequestImpl implements PageableRequest {
    public static final int size = 10;
    @Override
    public Pageable make(Integer page) {
        if (page == null) {
            page = 0;
        }
        if (page < 0) {
            page = 0;
        }
        return PageRequest.of(page, size);
    }
}

package com.coding.pre.onboarding.demo1.exception;

import com.coding.pre.onboarding.demo1.exception.base.BaseException;
import com.coding.pre.onboarding.demo1.exception.base.ErrorCode;

public class PostNotFoundException extends BaseException {
    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}

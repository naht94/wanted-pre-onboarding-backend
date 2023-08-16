package com.coding.pre.onboarding.demo1.exception.base;

public class BaseException extends RuntimeException {
    public BaseException(ErrorCode error) {
        super(error.getMessage());
    }
}

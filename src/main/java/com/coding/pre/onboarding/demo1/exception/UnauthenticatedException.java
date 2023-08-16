package com.coding.pre.onboarding.demo1.exception;

import com.coding.pre.onboarding.demo1.exception.base.BaseException;
import com.coding.pre.onboarding.demo1.exception.base.ErrorCode;

public class UnauthenticatedException extends BaseException {
    public UnauthenticatedException() {
        super(ErrorCode.UNAUTHENTICATED);
    }
}

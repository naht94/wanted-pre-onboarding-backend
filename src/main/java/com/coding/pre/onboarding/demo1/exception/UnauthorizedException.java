package com.coding.pre.onboarding.demo1.exception;

import com.coding.pre.onboarding.demo1.exception.base.BaseException;
import com.coding.pre.onboarding.demo1.exception.base.ErrorCode;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}

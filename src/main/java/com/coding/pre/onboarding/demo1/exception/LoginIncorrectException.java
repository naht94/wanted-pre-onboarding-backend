package com.coding.pre.onboarding.demo1.exception;

import com.coding.pre.onboarding.demo1.exception.base.BaseException;
import com.coding.pre.onboarding.demo1.exception.base.ErrorCode;

public class LoginIncorrectException extends BaseException {
    public LoginIncorrectException() {
        super(ErrorCode.LOGIN_INCORRECT);
    }
}

package com.coding.pre.onboarding.demo1.exception;

import com.coding.pre.onboarding.demo1.exception.base.BaseException;
import com.coding.pre.onboarding.demo1.exception.base.ErrorCode;

public class EmailAlreadyExist extends BaseException {
    public EmailAlreadyExist() {
        super(ErrorCode.EMAIL_EXIST);
    }

}

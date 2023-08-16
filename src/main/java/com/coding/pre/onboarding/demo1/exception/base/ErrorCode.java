package com.coding.pre.onboarding.demo1.exception.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    USER_NOT_FOUND("존재하지 않은 사용자"),
    EMAIL_EXIST("이메일 중복"),
    POST_NOT_FOUND("존재하지 않은 게시글"),
    UNAUTHORIZED("허가되지 않은 작성자"),
    UNAUTHENTICATED("비인가 작성자"),
    LOGIN_INCORRECT("이메일 혹은 비밀번호 오류");
    private final String message;
}

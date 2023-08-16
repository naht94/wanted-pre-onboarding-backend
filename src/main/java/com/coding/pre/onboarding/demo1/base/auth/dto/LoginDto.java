package com.coding.pre.onboarding.demo1.base.auth.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginDto {
    @Pattern(regexp = "^.*@.*$", message = "이메일 형식이 맞지 않습니다.")
    @NotNull
    private final String email;
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private final String pwd;
}

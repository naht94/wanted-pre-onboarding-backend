package com.coding.pre.onboarding.demo1.base.auth.service;

import com.coding.pre.onboarding.demo1.base.auth.dto.LoginDto;
import com.coding.pre.onboarding.demo1.base.auth.jwt.JwtToken;

public interface AuthService {
    String signUp(LoginDto dto);

    JwtToken login(String emailId, String password);
}

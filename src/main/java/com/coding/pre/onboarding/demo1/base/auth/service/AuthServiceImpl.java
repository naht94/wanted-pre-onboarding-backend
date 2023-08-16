package com.coding.pre.onboarding.demo1.base.auth.service;

import com.coding.pre.onboarding.demo1.base.auth.dto.LoginDto;
import com.coding.pre.onboarding.demo1.base.auth.jwt.JwtToken;
import com.coding.pre.onboarding.demo1.base.auth.jwt.JwtTokenProvider;
import com.coding.pre.onboarding.demo1.exception.EmailAlreadyExist;
import com.coding.pre.onboarding.demo1.exception.LoginIncorrectException;
import com.coding.pre.onboarding.demo1.user.entity.User;
import com.coding.pre.onboarding.demo1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    @Override
    public String signUp(LoginDto dto) {
        userRepository.findByEmail(dto.getEmail()).ifPresent(x -> {
            throw new EmailAlreadyExist();
        });

        String encode = passwordEncoder.encode(dto.getPwd());
        User user = User.makeUser(dto.getEmail(), encode);
        User result = userRepository.save(user);
        return result.getUsername();
    }

    @Transactional
    @Override
    public JwtToken login(String emailId, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(emailId, password);
            Authentication authentication =
                    authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            return jwtTokenProvider.generateToken(authentication);
        } catch (AuthenticationException e) {
            throw new LoginIncorrectException();
        }
    }
}

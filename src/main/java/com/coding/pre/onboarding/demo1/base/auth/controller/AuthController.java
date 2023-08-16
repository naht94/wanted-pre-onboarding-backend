package com.coding.pre.onboarding.demo1.base.auth.controller;

import com.coding.pre.onboarding.demo1.base.auth.dto.LoginDto;
import com.coding.pre.onboarding.demo1.base.auth.dto.SignUpResponseDto;
import com.coding.pre.onboarding.demo1.base.auth.jwt.JwtToken;
import com.coding.pre.onboarding.demo1.base.auth.service.AuthService;
import com.coding.pre.onboarding.demo1.exception.EmailAlreadyExist;
import com.coding.pre.onboarding.demo1.exception.LoginIncorrectException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    public static final String EMAIL_CONDITION = "^.*@.*$";
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody @Validated LoginDto dto,
                                         Errors errors) {
        if (errors.hasErrors()) {
            Map<String, String> error = getBindingErrors(errors);
            return ResponseEntity.badRequest().body(error);
        }
        try {
            String email = authService.signUp(dto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .replacePath("/api/users/" + email)
                    .build()
                    .toUri();
            return ResponseEntity.created(location).body(new SignUpResponseDto(email));
        } catch (EmailAlreadyExist e) {
            Map<String, String> error = getBindingError(e);
            return ResponseEntity.badRequest().body(error);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Validated LoginDto dto,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getBindingErrors(bindingResult);
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            JwtToken token = authService.login(dto.getEmail(), dto.getPwd());
            return ResponseEntity.ok(token);
        } catch (LoginIncorrectException e) {
            Map<String, String> errors = getBindingError(e);
            return ResponseEntity.badRequest().body(errors);
        }
    }
    private Map<String, String> getBindingErrors(Errors bindingResult) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }

    private Map<String, String> getBindingError(Exception e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("common", e.getMessage());
        return errors;
    }
}

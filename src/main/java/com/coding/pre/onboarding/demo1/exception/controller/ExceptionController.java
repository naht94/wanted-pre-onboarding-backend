package com.coding.pre.onboarding.demo1.exception.controller;

import com.coding.pre.onboarding.demo1.exception.PostNotFoundException;
import com.coding.pre.onboarding.demo1.exception.UnauthenticatedException;
import com.coding.pre.onboarding.demo1.exception.UnauthorizedException;
import com.coding.pre.onboarding.demo1.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Void> postNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> memberNotFound(Exception e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("common", e.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Map<String, String>> unauthorized(Exception e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("common", e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errors);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseEntity<Map<String, String>> unauthenticated(Exception e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("common", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errors);
    }
}

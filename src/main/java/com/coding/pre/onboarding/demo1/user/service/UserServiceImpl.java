package com.coding.pre.onboarding.demo1.user.service;

import com.coding.pre.onboarding.demo1.exception.UserNotFoundException;
import com.coding.pre.onboarding.demo1.user.dto.UserInfo;
import com.coding.pre.onboarding.demo1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserInfo getUser(Long userId) {
        return userRepository.findById(userId, UserInfo.class)
                .orElseThrow(UserNotFoundException::new);
    }
}

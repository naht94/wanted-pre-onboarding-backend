package com.coding.pre.onboarding.demo1.user.repository;

import com.coding.pre.onboarding.demo1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    <T> Optional<T> findById(Long id, Class<T> type);
}

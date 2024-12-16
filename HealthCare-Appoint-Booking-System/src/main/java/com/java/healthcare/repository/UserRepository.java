package com.java.healthcare.repository;

import com.java.healthcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find User by Email
    Optional<User> findByEmail(String email);

    // Check if a User with the given Email exists
    boolean existsByEmail(String email);

    // Check if a User with the given Phone exists
    boolean existsByPhone(String phone);
}


package com.leaveplanner.service;

import com.leaveplanner.domain.User;
import com.leaveplanner.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(String name, String email, LocalDate enlistmentDate) {
        // User 생성 (id는 null, createdAt은 현재 시간)
        User user = new User(
            null,
            name,
            email,
            enlistmentDate,
            LocalDate.now()
        );

        return userRepository.save(user);
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
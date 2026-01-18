package com.leaveplanner.service;

public interface UserService {

    User create(String name, String email, LocalDate enlistmentDate);

    Optional<User> findById(Long userId);

    List<User> findAll();
}
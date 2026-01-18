package com.leaveplanner.repository;

import com.leaveplanner.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository{
  
  public User save(User user);

  public Optional<User> findById(Long id);

  public List<User> findAll();
}
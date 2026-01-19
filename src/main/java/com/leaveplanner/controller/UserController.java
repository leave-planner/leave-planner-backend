package com.leaveplanner.controller;

import com.leaveplanner.domain.User;
import com.leaveplanner.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserController{
  
  private final UserService userService;

  public UserController(UserService userService){
    this.userService = userService;
  }

  //사용자 생성
  public Long createUser(
    String name,
    String email,
    LocalDate enlistmentDate
  ) {
  User user = userService.create(name, email, enlistmentDate);
  return user.getId();
  }

    
  //사용자 단건 조회
  public Optional<User> getUser(Long userId) {
  return userService.findById(userId);
  }

  
  //사용자 전체 조회 (테스트 / 관리용)  
  public List<User> getUsers() {
  return userService.findAll();
  }
}
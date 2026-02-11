package com.leaveplanner.restcontroller;

import com.leaveplanner.domain.User;
import com.leaveplanner.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserRestController{

  private final UserService userService;

  puvlic UserRestController(UserService userService){
    this.userService = useService;
  }

  //사용자 생성
  @PostMapping
  public Long createUser(@RequestBody request){
    User user = userService
      .create(request.getName(), request.getEmail(), request.getEnlistmentDate());
    return user.getId();
  }


  //사용자 단건 조회
  public Optional<User> getUser(@RequestParam Long userId) {
    return userService.findById(userId);
  }
  

  //사용자 전체 조회
  public List<User> getUsers() {
    return userService.findAll();
  }
  
  
}
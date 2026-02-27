package com.leaveplanner.restcontroller;

import com.leaveplanner.domain.User;
import com.leaveplanner.dto.UserCreateRequest;
import com.leaveplanner.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController{

  private final UserService userService;

  public UserRestController(UserService userService){
    this.userService = userService;
  }

  //사용자 생성
  @PostMapping
  public Long createUser(@RequestBody UserCreateRequest request){
    User user = userService
      .create(request.getName(), request.getEmail(), request.getEnlistmentDate());
    return user.getId();
  }


  //사용자 단건 조회
  @GetMapping("/{userId}")
  public Optional<User> getUser(@RequestParam Long userId) {
    return userService.findById(userId);
  }
  

  //사용자 전체 조회
  @GetMapping
  public List<User> getUsers() {
    return userService.findAll();
  }
  
  
}
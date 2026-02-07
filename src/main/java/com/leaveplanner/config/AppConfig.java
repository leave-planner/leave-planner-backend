package com.leaveplanner.config;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.User;

import com.leaveplanner.repository.LeaveDayRepository;
import com.leaveplanner.repository.UserRepository;
import com.leaveplanner.repository.InMemoryLeaveDayRepository;
import com.leaveplanner.repository.InMemoryUserRepository;

import com.leaveplanner.service.LeaveDayService;
import com.leaveplanner.service.UserService;

import com.leaveplanner.controller.LeaveDayController;
import com.leaveplanner.controller.UserController;

  
public class AppConfig{

  //repository
  public LeaveDayRepository leaveDayRepository(){
    return new InMemoryLeaveDayRepository();
  }
  
  public UserRepository userRepository(){
    return new InMemoryUserRepository();
  }

  //service
  public LeaveDayService leaveDayService(){
    return new LeaveDayService(leaveDayRepository());
  }
  
  public UserService userService(){
    return new UserService(userRepository());
  }

  //controller  
  public LeaveDayController leaveDayController() {
      return new LeaveDayController(leaveDayService());
  }
  
  public UserController userController() {
      return new UserController(userService());
  }
  
}
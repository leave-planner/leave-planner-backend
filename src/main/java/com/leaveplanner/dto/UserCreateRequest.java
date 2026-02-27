package com.leaveplanner.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserCreateRequest{
  
  private String name;
  private String email;
  private LocalDate enlistmentDate;

  //기본생성자
  public UserCreateRequest(){
  }

  //생성자
  public UserCreateRequest(String name, String email, LocalDate enlistmentDate){
    this.name = name;
    this.email = email;
    this.enlistmentDate = enlistmentDate;
  }


  
}
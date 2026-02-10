package com.leaveplanner.dto;

import java.time.LocalDate;


@Getter
public class LeaveDaySearchRequest {

  private Long userId;
  private LocalDate date;

  // 기본 생성자
  public LeaveDaySearchRequest() {
  }

  // 모든 필드 생성자
  public LeaveDaySearchRequest(Long userId, LocalDate date) {
    this.userId = userId;
    this.date = date;
  }
  
}
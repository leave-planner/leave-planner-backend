package com.leaveplanner.dto;

import java.time.LocalDate;

@Getter
public class MonthlyLeavesRequest {

  private Long userId;
  private LocalDate yearMonth; // 2024-03-01 형태로 받아서 year, month 추출

  // 기본 생성자
  public MonthlyLeavesRequest() {
  }

  // 모든 필드 생성자
  public MonthlyLeavesRequest(Long userId, LocalDate yearMonth) {
    this.userId = userId;
    this.yearMonth = yearMonth;
  }

}
package com.leaveplanner.dto;

import com.leaveplanner.domain.LeaveType;
import java.time.LocalDate;

@Getter
public class LeaveDayCreateRequest {

  private Long userId;
  private LocalDate date;
  private LeaveType leaveType;
  private String memo;

  // 기본 생성자
  public LeaveDayCreateRequest() {
  }

  // 모든 필드 생성자
  public LeaveDayCreateRequest(Long userId, LocalDate date, LeaveType leaveType, String memo) {
    this.userId = userId;
    this.date = date;
    this.leaveType = leaveType;
    this.memo = memo;
  }
  
}
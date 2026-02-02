package com.leaveplanner.domain;

import java.time.LocalDate;

public class LeaveDay{
  
  private Long leaveDayId;
  private final Long userId;
  private LeaveType leaveType;
  private LocalDate date;
  private final String memo;

  public LeaveDay(Long userId, LocalDate date, LeaveType leaveType, String memo){    
    this.userId = userId;
    this.leaveType = leaveType;
    this.date = date;
    this.memo = memo;
  }

  public void assignId(Long id){
    if (this.leaveDayId != null){
      throw new IllegalStateException("Id는 한번만 할당");
    }
    this.leaveDayId = id;
  }

  public Long getLeaveDayId(){
    return leaveDayId;
  }

  public Long getUserId(){
    return userId;
  }

  public LeaveType getLeaveType(){
    return leaveType;
  }

  public LocalDate getDate(){
    return date;
  }

  public String getMemo(){
    return memo;
  }
  
}
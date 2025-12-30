package com.leaveplanner.domain;

import java.time.LocalDate;

public class LeaveDay{
  
  private final Long leaveDayId;
  private final Long userId;
  private final LeaveType subType;
  private LocalDate date;
  private final String memo;

  public LeaveDay(Long leaveDayId, Long userId, LeaveType subType, LocalDate date, String memo){
    this.leaveDayId = leaveDayId;
    this.userId = userId;
    this.subType = subType;
    this.date = date;
    this.memo = memo;
  }

  public Long getLeaveDayId(){
    return leaveDayId;
  }

  public Long getUserId(){
    return userId;
  }

  public LeaveType getSubType(){
    return subType;
  }

  public LocalDate getDate(){
    return date;
  }

  public String getMemo(){
    return memo;
  }
  
}
package com.leaveplanner.domain;

import java.time.LocalDate;

public class LeaveDay{
  
  private final Long leaveDayId;
  private final Long userId;
  private final LeaveType subType;
  private LocalDate date;
  private final String memo;

  public LeaveDay(Long userId, LeaveType subType, LocalDate date, String memo){    
    this.userId = userId;
    this.subType = subType;
    this.date = date;
    this.memo = memo;
  }

  public void assignId(Long id){
    if (this.id != null){
      throw new IllegalStateException("Id는 한번만 할당");
    }
    this.id = id
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
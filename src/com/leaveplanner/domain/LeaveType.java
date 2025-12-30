package com.leaveplanner.domain;

public class LeaveType{

  private final Long leaveTypeId;
  private final String name;
  private final boolean isCustom;

  public LeaveType(Long leaveTypeId, String name, boolean isCustom){
    this.leaveTypeId = leaveTypeId;
    this.name = name;
    this.isCustom = isCustom;
  }

  public Long getLeaveTypeId(){
    return leaveTypeId;
  }

  public String getName(){
    return name;
  }

  
}
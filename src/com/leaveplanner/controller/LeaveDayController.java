package com.leaveplanner.controller;

import java.time.LocalDate;
import java.util.List;
import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.service.LeaveDayService;

public class LeaveDayController{

  private LeaveDayService leaveDayService;

  public LeaveDayController(LeaveDayService leaveDayService){
    this.leaveDayService = leaveDayService;
  }

  //휴가 등록
  public void createLeaveDay(Long userId, LocalDate date, Long leaveType, String memo){
    leaveDayService.create(userId, date, null, memo);
  }

  public List<LeaveDay> getMonthlyLeaves(Long userId, LocalDate date){
    return leaveDayService.getMonthlyLeaves(userId, date);
  }
}
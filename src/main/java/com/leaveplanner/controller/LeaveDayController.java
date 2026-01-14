package com.leaveplanner.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.service.LeaveDayService;
import com.leaveplanner.dto.ContinuousLeave;

public class LeaveDayController{

  private LeaveDayService leaveDayService;

  public LeaveDayController(LeaveDayService leaveDayService){
    this.leaveDayService = leaveDayService;
  }

  //휴가 등록
  public void createLeaveDay(Long userId, LocalDate date, Long leaveType, String memo){
    leaveDayService.create(userId, date, null, memo);
  }

  // 특정 날짜 휴가 조회
  public Optional<LeaveDay> findLeaveDay(Long userId, LocalDate date){
    return leaveDayService.findLeaveDay(userId, date);
  }

  // 연속 휴가 조회
    public Optional<ContinuousLeave> findContinuousLeave(Long userId, LocalDate date) {
        return leaveDayService.findContinuousLeave(userId, date);
    }

  // 월별 휴가 목록 조회
  public List<LeaveDay> getMonthlyLeaves(Long userId, int year, int month){
     return leaveDayService.findLeaveDaysByMonth(userId, year, month);
   }

  // 휴가 삭제
  public void deleteLeaveDay(Long leaveDayId){
    leaveDayService.deleteLeaveDay(leaveDayId);
  }
  
}
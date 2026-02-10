package com.leaveplanner.restcontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.LeaveType;
import com.leaveplanner.service.LeaveDayService;
import com.leaveplanner.dto.ContinuousLeave;

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/leave-days")
public class LeaveDayRestController{

  private final LeaveDayService leaveDayService;

  public LeaveDayController(LeaveDayService leaveDayService) {
    this.leaveDayService = leaveDayService;
  }

  //휴가 등록
  @PostMapping
  public void createLeaveDay(Long userId, LocalDate date, LeaveType leaveType, String memo){
    
  }
    
  
}
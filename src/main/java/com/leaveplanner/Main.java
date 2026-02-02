package com.leaveplanner;

import com.leaveplanner.config.AppConfig;
import com.leaveplanner.controller.LeaveDayController;
import com.leaveplanner.domain.LeaveType;
import com.leaveplanner.domain.LeaveDay;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
   
  public static void main(String[] args) {
     System.out.println("Leave Planner started!");

     AppConfig config = new AppConfig();
     LeaveDayController controller = config.leaveDayController();

     //test용
     Long testUserId = 1L;
     LeaveType testAnnualType = LeaveType.ANNUAL;
     LocalDate testdate1 = LocalDate.of(2026, 1, 10);   
     LocalDate testdate2 = LocalDate.of(2026, 1, 11);


     //휴가생성
     controller.createLeaveDay(testUserId, testdate1, testAnnualType, "연가1");
     controller.createLeaveDay(testUserId, testdate2, testAnnualType, "연가2");

     //휴가조회
     Optional<LeaveDay> leave = controller.findLeaveDay(testUserId,testdate1);

     // 월별 휴가 조회
     List<LeaveDay> monthLeaveDayList = controller.getMonthlyLeaves(testUserId, 2026, 1);

     //출력
     System.out.println(monthLeaveDayList);     
  }   
}

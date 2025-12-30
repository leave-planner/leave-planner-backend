package com.leaveplanner.service;

import java.time.LocalDate;
import java.util.List;
import java.time.YearMonth;
import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.LeaveType;
import com.leaveplanner.repository.LeaveDayRepository;

public class LeaveDayService{

  private LeaveDayRepository leaveDayRepository;

  public LeaveDayService(LeaveDayRepository leaveDayRepository){
    this.leaveDayRepository = leaveDayRepository;
  }

  //휴가 날짜 생성
  public void create(Long userId, LocalDate date, LeaveType leaveType, String memo){

    //해당 날짜 휴가존재 예외처리
    if (leaveDayRepository.existsByUserIdAndDate(userId,date)){
      throw new IllegalStateException("이미 해당 날짜 휴가 존재");
    }

    //leaveDay 생성
    LeaveDay leaveDay = new LeaveDay(1L, userId, leaveType, date, memo);
    //repository로
    leaveDayRepository.save(leaveDay);
  }

  //한달치 휴가 조회
  public List<LeaveDay> getMonthlyLeaves(Long userId, LocalDate date){
    YearMonth month = YearMonth.from(date);
    return leaveDayRepository.findByuserIdAndMonth(userId, month);
  }
}
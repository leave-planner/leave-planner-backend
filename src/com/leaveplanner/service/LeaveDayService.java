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
    Optional<LeaveDay> existing = leaveDayREpository.findByUserIdAndDate(userId, date);
    if (existing.isPresent()){
      throw new IllegalStateException("이미 해당 날짜 휴가 존재");
    }

    //leaveDay 생성
    LeaveDay leaveDay = new LeaveDay(userId, leaveType, date, memo);

    //repository로
    return leaveDayRepository.save(leaveDay);
  }

  
  /**
   * 특정 날짜 휴가 조회
   */
  public Optional<LeaveDay> findLeaveDay(Long userId, LocalDate date) {
      return leaveDayRepository.findByUserIdAndDate(userId, date);
  }

  /**
   * 월별 휴가 조회
   */
  public List<LeaveDay> findLeaveDaysByMonth(Long userId, int year, int month) {
      return leaveDayRepository.findAllByUserIdAndMonth(userId, year, month);
  }

  /**
   * 휴가 삭제
   */
  public void deleteLeaveDay(Long leaveDayId) {
      leaveDayRepository.delete(leaveDayId);
  }

  

  
}
package com.leaveplanner.service;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.LeaveType;
import com.leaveplanner.repository.LeaveDayRepository;
import com.leaveplanner.dto.ContinuousLeave;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class LeaveDayService{

  private LeaveDayRepository leaveDayRepository;

  public LeaveDayService(LeaveDayRepository leaveDayRepository){
    this.leaveDayRepository = leaveDayRepository;
  }

//휴가 날짜 생성
  public LeaveDay create(Long userId, LocalDate date, LeaveType leaveType, String memo){

    //해당 날짜 휴가존재 예외처리
    Optional<LeaveDay> existing = leaveDayRepository.findByUserIdAndDate(userId, date);
    if (existing.isPresent()){
      throw new IllegalStateException("이미 해당 날짜 휴가 존재");
    }    

    //leaveDay 생성
    LeaveDay leaveDay = new LeaveDay(userId, date, leaveType, memo);

    //repository로
    return leaveDayRepository.save(leaveDay);
  }

  
//특정 날짜 휴가 조회
  public Optional<LeaveDay> findLeaveDay(Long userId, LocalDate date) {
      return leaveDayRepository.findByUserIdAndDate(userId, date);
  }


//연속된 휴가 조회
  public Optional<ContinuousLeave> findContinuousLeave(Long userId, LocalDate date) {

      // 1. 해당 날짜에 LeaveDay 있는지 확인
      Optional<LeaveDay> target = leaveDayRepository.findByUserIdAndDate(userId, date);
      if (target.isEmpty()) {
          return Optional.empty();
      }

      // 2. 앞/뒤로 날짜 확장하면서 연속된 LeaveDay 조회
      List<LeaveDay> continuous = leaveDayRepository.findContinuousLeaveDays(
          userId, date
      );

      // 3. 시작일 / 종료일 계산
      LocalDate start = continuous.get(0).getDate();
      LocalDate end = continuous.get(continuous.size() - 1).getDate();

      return Optional.of(new ContinuousLeave(start, end, continuous));
  }

  
  

//월별 휴가 조회
  public List<LeaveDay> findLeaveDaysByMonth(Long userId, int year, int month) {
      return leaveDayRepository.findAllByUserIdAndMonth(userId, year, month);
  }


//휴가 삭제
  public void deleteLeaveDay(Long leaveDayId) {
      leaveDayRepository.delete(leaveDayId);
  }

  
  
}
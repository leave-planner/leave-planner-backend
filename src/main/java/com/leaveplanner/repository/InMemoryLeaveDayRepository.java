package com.leaveplanner.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.leaveplanner.domain.LeaveDay;

import java.util.Optional;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryLeaveDayRepository implements LeaveDayRepository{


  // 임시 저장 map 객체
  private final Map<Long, LeaveDay> store = new HashMap<>();
  private final AtomicLong sequence = new AtomicLong(1);


  // LeaveDay 저장
  @Override
  public LeaveDay save(LeaveDay leaveDay){
    
    //저장된적 없는지 확인
    if (leaveDay.getLeaveDayId() == null){
      leaveDay.assignId(sequence.getAndIncrement());
    }
    // id를 pk역할로, map에 저장
    store.put(leaveDay.getLeaveDayId(), leaveDay);
    
    return leaveDay;
  }

  // userId와 날짜로 LeaveDay 조회
  @Override
  public Optional<LeaveDay> findByUserIdAndDate(Long userId, LocalDate date) {
      return store.values().stream()
              .filter(ld -> ld.getUserId().equals(userId))
              .filter(ld -> ld.getDate().equals(date))
              .findFirst();
  }

  // userId와 월로 해당 월 휴가 목록 조회
  @Override
  public List<LeaveDay> findAllByUserIdAndMonth(Long userId, int year, int month) {
      return store.values().stream()
              .filter(ld -> ld.getUserId().equals(userId))
              .filter(ld -> ld.getDate().getYear() == year)
              .filter(ld -> ld.getDate().getMonthValue() == month)
              .toList();
  }


  // 삭제
  @Override
  public void delete(Long leaveDayId) {
      store.remove(leaveDayId);
  }

  
}
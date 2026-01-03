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

  
  @Override
  public Optional<LeaveDay> findByUserIdAndDate(Long userId, LocalDate date) {
      return store.values().stream()
              .filter(ld -> ld.getUserId().equals(userId))
              .filter(ld -> ld.getDate().equals(date))
              .findFirst();
  }

  
  @Override
  public List<LeaveDay> findAllByUserIdAndMonth(Long userId, int year, int month) {
      return store.values().stream()
              .filter(ld -> ld.getUserId().equals(userId))
              .filter(ld -> ld.getDate().getYear() == year)
              .filter(ld -> ld.getDate().getMonthValue() == month)
              .toList();
  }

  
  @Override
  public void delete(Long leaveDayId) {
      store.remove(leaveDayId);
  }

  
}
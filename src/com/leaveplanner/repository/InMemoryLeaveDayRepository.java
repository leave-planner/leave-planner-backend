package com.leaveplanner.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.leaveplanner.domain.LeaveDay;

public class InMemoryLeaveDayRepository implements LeaveDayRepository{


  // 임시 저장 map 객체
  private final Map<Long, Map<LocalDate, LeaveDay>> store = new HashMap<>();

  @Override
  public void save(LeaveDay leaveDay){
    store
      .computeIfAbsent(leaveDay.getUserId(), id -> new HashMap<>())
      .put(leaveDay.getDate(), leaveDay);
  }

  @Override
  public boolean existsByUserIdAndDate(Long userId, LocalDate date){
    return store.containsKey(userId) && store.get(userId).containsKey(date);
  }

  @Override
  public java.util.List<LeaveDay> findByuserIdAndMonth(Long userId, java.time.YearMonth month){
    // 구현 생략 (인메모리 검색 로직)
    return new java.util.ArrayList<>();
  }
}
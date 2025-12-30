package com.leaveplanner.repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import com.leaveplanner.domain.LeaveDay;

public interface LeaveDayRepository{
  
  void save(LeaveDay leaveDay);
  boolean existsByUserIdAndDate(Long userId, LocalDate date);

  List<LeaveDay> findByuserIdAndMonth(Long userId, YearMonth month);
  
}
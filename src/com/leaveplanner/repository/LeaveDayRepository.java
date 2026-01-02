package com.leaveplanner.repository;

import java.util.Optional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import com.leaveplanner.domain.LeaveDay;

public interface LeaveDayRepository{
  
  LeaveDay save(LeaveDay leaveDay);
  
  Optional<LeaveDay> findByUserIdAndDate(Long userId, LocalDate date);

  List<LeaveDay> findByuserIdAndMonth(Long userId, int year,int month);

  void delete(Long leaveDayId);
}
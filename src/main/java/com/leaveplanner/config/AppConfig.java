package com.leaveplanner.config;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.repository.LeaveDayRepository;
import com.leaveplanner.repository.InMemoryLeaveDayRepository;

public class AppConfig{
  
  public LeaveDayRepository leaveDayRepository(){
    return new InMemoryLeaveDayRepository();
  }
}
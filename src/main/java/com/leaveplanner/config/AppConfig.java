package com.leaveplanner.config;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.repository.LeaveDayRepository;
import com.leaveplanner.repository.InMemoryLeaveDayRepository;
import com.leaveplanner.service.LeaveDayService;
import com.leaveplanner.controller.LeaveDayController;

  
public class AppConfig{
  
  public LeaveDayRepository leaveDayRepository(){
    return new InMemoryLeaveDayRepository();
  }

  public LeaveDayService leaveDayService(){
    return new LeaveDayService(leaveDayRepository());
  }

  public LeaveDayController leaveDayController() {
      return new LeaveDayController(leaveDayService());
  }
}
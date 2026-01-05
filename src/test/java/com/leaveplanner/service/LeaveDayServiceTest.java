package com.leaveplanner.service;

import com.leaveplanner.repository.LeaveDayRepository;
import com.leaveplanner.service.LeaveDayService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;



class LeaveDayServiceTest{

  private LeaveDayService service;
  private LeaveDayRepository repository;

  @BeforeEach
  void setUp(){
    service = new LeaveDayService();
    repository = new LeaveDayRepository();
  }

  @Test
  void 휴가날짜_생성(){
    //given
    LeaveDayType annual = new LeaveDayType(1L, "ANNUAL", true);
    LocalDate date = LocalDate.of(2026,1,10);
    //when
    LeaveDay leaveDay = service.create(1L, date, annual, "연가");

    //then       
    assertThat(leaveDay.getUserId()).isEqualTo(1L);
    
    
  }
  
  
}
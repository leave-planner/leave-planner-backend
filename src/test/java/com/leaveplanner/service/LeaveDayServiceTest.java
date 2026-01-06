package com.leaveplanner.service;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.LeaveType;
import com.leaveplanner.repository.InMemoryLeaveDayRepository;
import com.leaveplanner.repository.LeaveDayRepository;
import com.leaveplanner.service.LeaveDayService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;


class LeaveDayServiceTest{

  private LeaveDayService service;
  private LeaveDayRepository repository;

  @BeforeEach
  void setUp(){    
    repository = new InMemoryLeaveDayRepository();
    service = new LeaveDayService(repository);
  }

  @Test
  void 휴가를_정상적으로_등록할_수_있다(){
    //given
    LeaveType annual = new LeaveType(1L, "ANNUAL", true);
    LocalDate date = LocalDate.of(2026,1,10);
    //when
    LeaveDay leaveDay = service.create(1L, date, annual, "연가");

    //then       
    assertThat(leaveDay.getUserId()).isEqualTo(1L);  
    
  }

  @Test
  void 같은_날짜에_휴가는_한번만_등록_가능하다() {
      // given
      LeaveType annual = new LeaveType(1L, "ANNUAL", true);
      LocalDate date = LocalDate.of(2026, 1, 10);

      service.create(1L, date, annual, "첫 휴가");

      // then
      assertThatThrownBy(() ->
          service.create(1L, date, annual, "중복 휴가")
      ).isInstanceOf(IllegalStateException.class);
  }
  

  @Test
  void 월별_휴가목록을_조회할_수_있다(){
    //given
    LeaveType annual = new LeaveType(1L,"ANNUAL",true);

    service.create(1L, LocalDate.of(2026,1,10), annual, "연가");
    service.create(1L, LocalDate.of(2026,1,11), annual, "연가");
    service.create(1L, LocalDate.of(2026,2,10), annual, "연가");

    // when
    List<LeaveDay> Leaves = service.findLeaveDaysByMonth(1L, 2026, 1);

    // then
    assertThat(Leaves).hasSize(2);
    assertThat(Leaves).allMatch(ld -> ld.getDate().getMonthValue() == 1);    
    
  }

  @Test
  void 휴가를_삭제할_수_있다() {
      // given
      LeaveType annual = new LeaveType(1L, "ANNUAL", true);
      LocalDate date = LocalDate.of(2026, 1, 10);

      LeaveDay leaveDay =
              service.create(1L, date, annual, "연차");

      // when
      service.deleteLeaveDay(leaveDay.getLeaveDayId());

      // then
      assertThat(
          repository.findByUserIdAndDate(1L, date)
      ).isEmpty();
  }
  
  
}
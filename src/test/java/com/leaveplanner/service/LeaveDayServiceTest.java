package com.leaveplanner.service;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.LeaveType;
import com.leaveplanner.repository.InMemoryLeaveDayRepository;
import com.leaveplanner.repository.LeaveDayRepository;
import com.leaveplanner.dto.ContinuousLeave;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

class LeaveDayServiceTest {    

    private LeaveDayService service;
    private LeaveDayRepository repository;

    @BeforeEach
    void setUp() {    
        repository = new InMemoryLeaveDayRepository();
        service = new LeaveDayService(repository);
    }

    @Test
    void 휴가를_정상적으로_등록할_수_있다() {
        //given
        LocalDate date = LocalDate.of(2026, 1, 10);

        //when
        LeaveDay leaveDay = service.create(1L, date, LeaveType.ANNUAL, "연가");

        //then       
        assertThat(leaveDay.getUserId()).isEqualTo(1L);  
    }

    @Test
    void 같은_날짜에_휴가는_한번만_등록_가능하다() {
        // given
        LocalDate date = LocalDate.of(2026, 1, 10);
        service.create(1L, date, LeaveType.ANNUAL, "첫 휴가");

        // then
        assertThatThrownBy(() ->
            service.create(1L, date, LeaveType.ANNUAL, "중복 휴가")
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 월별_휴가목록을_조회할_수_있다() {
        //given
        service.create(1L, LocalDate.of(2026, 1, 10), LeaveType.ANNUAL, "연가");
        service.create(1L, LocalDate.of(2026, 1, 11), LeaveType.ANNUAL, "연가");
        service.create(1L, LocalDate.of(2026, 2, 10), LeaveType.ANNUAL, "연가");

        // when
        List<LeaveDay> leaves = service.findLeaveDaysByMonth(1L, 2026, 1);

        // then
        assertThat(leaves).hasSize(2);
        assertThat(leaves).allMatch(ld -> ld.getDate().getMonthValue() == 1);  
    }

    @Test
    void 기준날짜에_휴가가_없으면_empty() {
        //given
        Long userId = 1L;
        LocalDate date = LocalDate.of(2026, 1, 10);

        //when
        Optional<ContinuousLeave> result = service.findContinuousLeave(userId, date);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    void 하루짜리_휴가() {
        //given
        Long userId = 1L;
        LocalDate date = LocalDate.of(2026, 1, 10);
        service.create(userId, date, LeaveType.ANNUAL, "연가");

        //when
        ContinuousLeave result = service.findContinuousLeave(userId, date).get();

        //then
        assertThat(result.getStartDate()).isEqualTo(date);
        assertThat(result.getEndDate()).isEqualTo(date);
        assertThat(result.getLeaveDays()).hasSize(1);
    }

    @Test
    void 연속된_휴가_조회() {
        //given
        Long userId = 1L;
        LocalDate date1 = LocalDate.of(2026, 1, 10);
        LocalDate date2 = LocalDate.of(2026, 1, 11);
        LocalDate date3 = LocalDate.of(2026, 1, 12);

        service.create(userId, date1, LeaveType.ANNUAL, "연가");
        service.create(userId, date2, LeaveType.ANNUAL, "연가");
        service.create(userId, date3, LeaveType.ANNUAL, "연가");

        //when
        ContinuousLeave result = service.findContinuousLeave(userId, LocalDate.of(2026, 1, 10)).get();

        //then
        assertThat(result.getStartDate()).isEqualTo(date1);
        assertThat(result.getEndDate()).isEqualTo(date3);
    }

    @Test
    void 중간에_끊긴_휴가는_묶이지_않는다() {
        //given
        Long userId = 1L;
        LocalDate date1 = LocalDate.of(2026, 1, 10);
        LocalDate date2 = LocalDate.of(2026, 1, 11);
        LocalDate date3 = LocalDate.of(2026, 1, 12);
        LocalDate date4 = LocalDate.of(2026, 1, 14);

        service.create(userId, date1, LeaveType.ANNUAL, "연가");
        service.create(userId, date2, LeaveType.ANNUAL, "연가");
        service.create(userId, date3, LeaveType.ANNUAL, "연가");
        service.create(userId, date4, LeaveType.ANNUAL, "연가");

        //when
        ContinuousLeave result = service.findContinuousLeave(userId, LocalDate.of(2026, 1, 12)).get();

        //then
        assertThat(result.getStartDate()).isEqualTo(date1);
        assertThat(result.getEndDate()).isEqualTo(date3);
    }

    @Test
    void 휴가를_삭제할_수_있다() {
        // given
        LocalDate date = LocalDate.of(2026, 1, 10);
        LeaveDay leaveDay = service.create(1L, date, LeaveType.ANNUAL, "연차");

        // when
        service.deleteLeaveDay(leaveDay.getLeaveDayId());

        // then
        assertThat(repository.findByUserIdAndDate(1L, date)).isEmpty();
    }
}
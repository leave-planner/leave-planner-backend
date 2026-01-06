package com.leaveplanner.repository;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.LeaveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InMemoryLeaveDayRepositoryTest {

    private InMemoryLeaveDayRepository repository;

    @BeforeEach
    void setUp(){
        repository = new InMemoryLeaveDayRepository();
    }

    @Test
    void 저장하면_id가_할당된다() {         
        //given
        LeaveType annual = new LeaveType(1L, "ANNUAL", true);
        LeaveDay leaveDay = new LeaveDay(1L, annual, LocalDate.of(2026, 1, 10), "연차");

        //when
        LeaveDay saved = repository.save(leaveDay);

        //then
        assertThat(saved.getLeaveDayId()).isNotNull();    
    }
    

    @Test
    void 사용자와_날짜로_휴가를_조회할_수_있다() {
        // given
        LeaveType annual = new LeaveType(1L, "ANNUAL", true);
        LocalDate date = LocalDate.of(2026, 1, 10);

        LeaveDay leaveDay = new LeaveDay(1L, annual, date, "연차");
        repository.save(leaveDay);

        // when
        Optional<LeaveDay> result =
        repository.findByUserIdAndDate(1L, date);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().getMemo()).isEqualTo("연차");
        }
    

    @Test
    void 사용자와_월로_휴가_목록을_조회한다(){
        //given
        LeaveType annual = new LeaveType(1L,"ANNUAL",true);       

        LeaveDay leaveDay1 = new LeaveDay(1L, annual, LocalDate.of(2026, 1, 10), "연차");
        LeaveDay leaveDay2 = new LeaveDay(1L, annual, LocalDate.of(2026, 1, 11), "연차");
        LeaveDay leaveDay3 = new LeaveDay(1L, annual, LocalDate.of(2026, 2, 10), "연차");

        repository.save(leaveDay1);
        repository.save(leaveDay2);
        repository.save(leaveDay3);

        //when
        List<LeaveDay> leaves = repository.findAllByUserIdAndMonth(1L,2026,1);

        //then        
        assertThat(leaves).hasSize(2);
        assertThat(leaves).allMatch(ld -> ld.getDate().getMonthValue() == 1);
        
    }

    @Test
    void 휴가를_삭제할_수_있다() {
        // given
        LeaveType annual = new LeaveType(1L, "ANNUAL", true);
        LeaveDay leaveDay 
            = repository.save(new LeaveDay(1L, annual, LocalDate.of(2026, 1, 10), "연차"));

        // when
        repository.delete(leaveDay.getLeaveDayId());

        // then
        Optional<LeaveDay> result
            = repository.findByUserIdAndDate(1L, LocalDate.of(2026, 1, 10));
        assertThat(result).isEmpty();


    }
}
package com.leaveplanner.repository;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.LeaveType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class InMemoryLeaveDayRepositoryTest {

    @Test
    void 저장하면_id가_할당된다() {
        InMemoryLeaveDayRepository repository = new InMemoryLeaveDayRepository();

        LeaveType annual = new LeaveType(1L, "ANNUAL", true);

        LeaveDay leaveDay = new LeaveDay(
                1L,
                annual,
                LocalDate.of(2026, 1, 10),
                "연차"
        );

        LeaveDay saved = repository.save(leaveDay);

        assertThat(saved.getLeaveDayId()).isNotNull();
    }
}
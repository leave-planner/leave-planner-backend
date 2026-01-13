package com.leaveplanner;

import java.time.LocalDate;
import java.util.List;

public class ContinuousLeave {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final List<LeaveDay> leaveDays;

    public ContinuousLeave(
            LocalDate startDate,
            LocalDate endDate,
            List<LeaveDay> leaveDays
    ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveDays = leaveDays;
    }

    
}
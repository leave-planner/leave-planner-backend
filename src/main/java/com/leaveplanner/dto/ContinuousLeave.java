package com.leaveplanner.dto;

import com.leaveplanner.domain.LeaveDay;
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

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public List<LeaveDay> getLeaveDays(){
        return leaveDays;
    }
}
package com.leaveplanner;

import com.leaveplanner.controller.LeaveDayController;
import com.leaveplanner.repository.InMemoryLeaveDayRepository;
import com.leaveplanner.repository.LeaveDayRepository;
import com.leaveplanner.service.LeaveDayService;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LeaveDayRepository repository = new InMemoryLeaveDayRepository();
        LeaveDayService service = new LeaveDayService(repository);
        LeaveDayController controller = new LeaveDayController(service);

        System.out.println("Java Leave Planner Application Started!");
        
        // 간단한 테스트 실행
        try {
            controller.createLeaveDay(1L, LocalDate.now(), 1L, "연차 휴가");
            System.out.println("Successfully created a leave day.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

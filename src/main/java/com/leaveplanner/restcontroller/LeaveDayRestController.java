package com.leaveplanner.restcontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.leaveplanner.domain.LeaveDay;
import com.leaveplanner.domain.LeaveType;
import com.leaveplanner.service.LeaveDayService;
import com.leaveplanner.dto.ContinuousLeave;

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/leave-days")
public class LeaveDayRestController{

  private final LeaveDayService leaveDayService;

  public LeaveDayController(LeaveDayService leaveDayService) {
    this.leaveDayService = leaveDayService;
  }

  // 휴가 등록
  @PostMapping
  public LeaveDay createLeaveDay(@RequestBody LeaveDayCreateRequest request) {
    return leaveDayService.create(
      request.getUserId(),
      request.getDate(),
      request.getLeaveType(),
      request.getMemo()
    );
  }

  // 특정 날짜 휴가 조회
  @GetMapping
  public Optional<LeaveDay> findLeaveDay(@ModelAttribute LeaveDaySearchRequest request) {
    return leaveDayService.findLeaveDay(request.getUserId(), request.getDate());
  }

  // 연속 휴가 조회
  @GetMapping("/continuous")
  public Optional<ContinuousLeave> findContinuousLeave(@ModelAttribute LeaveDaySearchRequest request) {
    return leaveDayService.findContinuousLeave(request.getUserId(), request.getDate());
  }

  // 월별 휴가 목록 조회
  @GetMapping("/monthly")
  public List<LeaveDay> getMonthlyLeaves(@ModelAttribute MonthlyLeavesRequest request) {
    // LocalDate에서 year, month 추출
    int year = request.getYearMonth().getYear();
    int month = request.getYearMonth().getMonthValue();

    return leaveDayService.findLeaveDaysByMonth(request.getUserId(), year, month);
  }

  // 휴가 삭제
  @DeleteMapping("/{leaveDayId}")
  public void deleteLeaveDay(@PathVariable Long leaveDayId) {
    leaveDayService.deleteLeaveDay(leaveDayId);
  }
    
  
}
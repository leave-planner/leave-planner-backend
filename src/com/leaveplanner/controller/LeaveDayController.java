import java.time.LocalDate;

public class LeaveDayControllr{

  private LeaveDaySerivice leaveDayService;

  public LeaveDayControllr(LeaveDaySerivice leaveDayService){
    this.leaveDayService = leaveDayService;
  }

  //휴가 등록
  public void createLeaveDay(Long userId, LocalDate date, Long leaveType, String memo){
    leaveDayService.createLeaveDay(userId, date, leaveType, memo);
  }

  public List<LeaveDay> getMonthlyLeaves(Long userId, LocalDate date){
    leaveDayService.getMonthlyLeaves(userId, dage);
  }


  
}
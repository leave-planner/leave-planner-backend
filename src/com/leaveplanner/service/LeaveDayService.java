import java.time.LocalDate;

public class LeaveDayService{

  private LeaveDayRepository leaveDayRepository;

  public LeaveDayService(leaveDayRepository leaveDayRepository){
    this.leaveDayRepository = leaveDayRepository;
  }

  //휴가 날짜 생성
  public void create(Long userId, LocalDate date, LeaveType leaveType, String memo){
    
  }

  public List<LeaveDay> getMonthlyLeaves(Long userId, LocalDate date){
    
  }
  
}
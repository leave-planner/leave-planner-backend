import java.time.LocalDate;
import src.com.leaveplanner.domain.LeaveDay;

public class LeaveDayService{

  private LeaveDayRepository leaveDayRepository;

  public LeaveDayService(leaveDayRepository leaveDayRepository){
    this.leaveDayRepository = leaveDayRepository;
  }

  //휴가 날짜 생성
  public void create(Long userId, LocalDate date, LeaveType leaveType, String memo){

    //해당 날짜 휴가존재 예외처리
    if (leaveDayRepository.existsByUserIdAndDate(userId,date)){
      throw new IlleagalStateException("이미 해당 날짜 휴가 존재");
    }

    //leaveDay 생성
    LeaveDay leaveDay = new LeaveDay(userId, leaveType, memo);
    //repository로
    leaveDayRepository.svae(leaveDay);
  }

  //한달치 휴가 조회
  public List<LeaveDay> getMonthlyLeaves(Long userId, LocalDate date){
    return leaveDayRepository.findByuserIdAndMonth(userId, month);
  }
  
}
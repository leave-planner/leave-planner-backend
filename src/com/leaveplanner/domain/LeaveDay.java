
import java.time.LocalDate;

import jave.time.localDate;

public class LeaveDay{
  
  private final Long leaveDayId;
  private final Long userId;
  private final LeaveType subType;
  private LocalDate date;
  private final String memo;

  public LeaveDay(Long leaveDAyId, Long userId, LeaveType subType, LocalDate date, String memo){
    this.leaveDAyId = leaveDAyId;
    this.userId = userId;
    this.subType = subType;
    this.date = date;
    this.memo = memo;
  }
  
}
import java.time.LocalDate;
import java.util.Optional;

public interface LeaveDayRepository{
  
  void save(LeaveDay leaveDay);
  boolean existsByUserIdAndDate(Long userId, LocalDate date);

  List<LeaveDay> findByuserIdAndMonth(Long userId, YearMonth month);
  
}
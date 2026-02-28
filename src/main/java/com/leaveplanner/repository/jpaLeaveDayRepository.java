package com.leaveplanner.repository;

import com.leaveplanner.domain.LeaveDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * LeaveDayRepository (JPA)
 *
 * JpaRepository를 상속받아 기본 CRUD 기능 제공
 */
@Repository
public interface jpaLeaveDayRepository extends JpaRepository<LeaveDay, Long> {

    /**
     * 특정 사용자의 특정 날짜 휴가 조회
     *
     * @param userId 사용자 ID
     * @param date 날짜
     * @return 휴가 (Optional)
     */
    Optional<LeaveDay> findByUserIdAndDate(Long userId, LocalDate date);

    /**
     * 특정 사용자의 날짜 범위 내 휴가 목록 조회 (날짜 오름차순)
     *
     * @param userId 사용자 ID
     * @param startDate 시작 날짜
     * @param endDate 종료 날짜
     * @return 휴가 목록
     */
    List<LeaveDay> findByUserIdAndDateBetweenOrderByDateAsc(
            Long userId,
            LocalDate startDate,
            LocalDate endDate
    );

    /**
     * 특정 사용자의 모든 휴가 조회 (날짜 오름차순)
     *
     * @param userId 사용자 ID
     * @return 휴가 목록
     */
    List<LeaveDay> findByUserIdOrderByDateAsc(Long userId);

    /**
     * 특정 사용자의 특정 날짜 이후 연속된 휴가 조회
     *
     * @param userId 사용자 ID
     * @param date 기준 날짜
     * @return 휴가 목록
     */
    @Query("SELECT ld FROM LeaveDay ld " +
            "WHERE ld.userId = :userId " +
            "AND ld.date >= :date " +
            "ORDER BY ld.date ASC")
    List<LeaveDay> findContinuousLeavesAfter(
            @Param("userId") Long userId,
            @Param("date") LocalDate date
    );

    /**
     * 특정 사용자의 특정 날짜 이전 연속된 휴가 조회
     *
     * @param userId 사용자 ID
     * @param date 기준 날짜
     * @return 휴가 목록 (역순)
     */
    @Query("SELECT ld FROM LeaveDay ld " +
            "WHERE ld.userId = :userId " +
            "AND ld.date <= :date " +
            "ORDER BY ld.date DESC")
    List<LeaveDay> findContinuousLeavesBefore(
            @Param("userId") Long userId,
            @Param("date") LocalDate date
    );
}









































































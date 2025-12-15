package com.example.Leave_System_BE.Repository;

import com.example.Leave_System_BE.Entity.LeaveRequestEntity;
import com.example.Leave_System_BE.EnumType.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequestEntity,Long> {
    @Query("SELECT leaveReq FROM LeaveRequestEntity leaveReq " +
            "JOIN FETCH leaveReq.user u " +
            "JOIN FETCH leaveReq.leaveTypeEntity leaveType " +
            "WHERE leaveReq.leaveStatus = :status")
    List<LeaveRequestEntity> findByLeaveStatus(@Param("status") StatusEnum status);

    @Query("SELECT leaveReq FROM LeaveRequestEntity leaveReq " +
            "JOIN FETCH leaveReq.user u " +
            "JOIN FETCH leaveReq.leaveTypeEntity leaveType")
    List<LeaveRequestEntity> findAllReq();
}

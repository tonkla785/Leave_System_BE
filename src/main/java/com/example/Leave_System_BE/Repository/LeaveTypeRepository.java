package com.example.Leave_System_BE.Repository;

import com.example.Leave_System_BE.Entity.LeaveTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveTypeEntity,Long> {
}

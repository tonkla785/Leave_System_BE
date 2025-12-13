package com.example.Leave_System_BE.Service;

import com.example.Leave_System_BE.Entity.LeaveTypeEntity;
import com.example.Leave_System_BE.EnumType.TypeLeaveEnum;
import com.example.Leave_System_BE.Repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeService {
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    public List<LeaveTypeEntity> createLeaveTypes() {
            LeaveTypeEntity sick = new LeaveTypeEntity();
            sick.setTypeName(TypeLeaveEnum.SICK);
            sick.setTypeDescription("ลาป่วย");
            sick.setMaxDay(10);
            leaveTypeRepository.save(sick);

            LeaveTypeEntity casual = new LeaveTypeEntity();
            casual.setTypeName(TypeLeaveEnum.CASUAL);
            casual.setTypeDescription("ลากิจ");
            casual.setMaxDay(5);
            leaveTypeRepository.save(casual);

            LeaveTypeEntity vacation = new LeaveTypeEntity();
            vacation.setTypeName(TypeLeaveEnum.VACATION);
            vacation.setTypeDescription("ลาพักร้อน");
            vacation.setMaxDay(15);
            leaveTypeRepository.save(vacation);

            return List.of(sick, casual, vacation);
    }


    public List<LeaveTypeEntity> getAllLeaveType() {
            return leaveTypeRepository.findAll();
    }
}

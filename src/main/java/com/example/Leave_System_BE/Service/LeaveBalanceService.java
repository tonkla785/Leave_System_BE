package com.example.Leave_System_BE.Service;

import com.example.Leave_System_BE.DTO.LeaveBalanceRequestDTO;
import com.example.Leave_System_BE.DTO.LeaveBalanceResponseDTO;
import com.example.Leave_System_BE.Entity.LeaveBalanceEntity;
import com.example.Leave_System_BE.Entity.LeaveTypeEntity;
import com.example.Leave_System_BE.Entity.UserEntity;
import com.example.Leave_System_BE.Repository.LeaveBalanceRepository;
import com.example.Leave_System_BE.Repository.LeaveTypeRepository;
import com.example.Leave_System_BE.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveBalanceService {
    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    //Create Balance
    public LeaveBalanceEntity createLeaveBalance(LeaveBalanceRequestDTO leaveBalanceRequestDTO){
        UserEntity user = userRepository.findById(leaveBalanceRequestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("ไม่พบข้อมูล user = " + leaveBalanceRequestDTO.getUserId()));
        LeaveTypeEntity type = leaveTypeRepository.findById(leaveBalanceRequestDTO.getLeaveTypeId())
                .orElseThrow(() -> new IllegalArgumentException("ไม่พบข้อมูล type = " + leaveBalanceRequestDTO.getLeaveTypeId()));

        LeaveBalanceEntity data = new LeaveBalanceEntity();

        data.setUser(user);
        data.setLeaveTypeEntity(type);
        data.setLeaveYear(leaveBalanceRequestDTO.getYear());
        data.setRemainDay(leaveBalanceRequestDTO.getRemainDay());
        return leaveBalanceRepository.save(data);
    }

    //Get All Balance
    public List<LeaveBalanceResponseDTO> getBalanceData(){
        List<LeaveBalanceEntity> data = leaveBalanceRepository.findAll();
        List<LeaveBalanceResponseDTO> dataResponse = new ArrayList<>();

        for (LeaveBalanceEntity object : data) {
            dataResponse.add(responseBalance(object));
        }

        return dataResponse;
    }

    private LeaveBalanceResponseDTO responseBalance(LeaveBalanceEntity entity) {
        return new LeaveBalanceResponseDTO(
                entity.getId(),
                entity.getLeaveYear(),
                entity.getRemainDay(),
                entity.getUser().getUserName(),
                entity.getLeaveTypeEntity().getTypeName()
        );
    }
}

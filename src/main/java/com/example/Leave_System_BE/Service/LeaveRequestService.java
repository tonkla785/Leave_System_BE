package com.example.Leave_System_BE.Service;

import com.example.Leave_System_BE.DTO.LeaveRequestDTO;
import com.example.Leave_System_BE.DTO.LeaveRequestResponseDTO;
import com.example.Leave_System_BE.Entity.LeaveRequestEntity;
import com.example.Leave_System_BE.Entity.LeaveTypeEntity;
import com.example.Leave_System_BE.Entity.UserEntity;
import com.example.Leave_System_BE.EnumType.StatusEnum;
import com.example.Leave_System_BE.Repository.LeaveRequestRepository;

import com.example.Leave_System_BE.Repository.LeaveTypeRepository;
import com.example.Leave_System_BE.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    //Create Req
    public LeaveRequestEntity createLeaveReq(LeaveRequestDTO leaveRequestDTO) {
            UserEntity user = userRepository.findById(leaveRequestDTO.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("ไม่พบข้อมูล user = " + leaveRequestDTO.getUserId()));
            LeaveTypeEntity type = leaveTypeRepository.findById(leaveRequestDTO.getLeaveTypeId())
                    .orElseThrow(() -> new IllegalArgumentException("ไม่พบข้อมูล type = " + leaveRequestDTO.getLeaveTypeId()));

            LeaveRequestEntity data = new LeaveRequestEntity();
            data.setUser(user);
            data.setLeaveTypeEntity(type);
            data.setLeaveStatus(StatusEnum.pending);
            data.setStartDate(leaveRequestDTO.getStartDate());
            data.setEndDate(leaveRequestDTO.getEndDate());
            data.setLeaveReason(leaveRequestDTO.getReason());

            return leaveRequestRepository.save(data);
    }

    // Update only leave status
    public LeaveRequestResponseDTO updateLeaveStatus(Long leaveRequestId, StatusEnum status) {
        LeaveRequestEntity leaveRequest = leaveRequestRepository.findById(leaveRequestId)
                .orElseThrow(() -> new IllegalArgumentException("ไม่พบข้อมูล leave request id = " + leaveRequestId));

        leaveRequest.setLeaveStatus(status);
        leaveRequest = leaveRequestRepository.save(leaveRequest);

        return responseData(leaveRequest);
    }


    //get all approved
    public List<LeaveRequestEntity> getLeaveRequestsByStatus(StatusEnum status) {
        return leaveRequestRepository.findByLeaveStatus(status);
    }

    //get all req
    public List<LeaveRequestEntity> getLeaveAllReq(){
        return leaveRequestRepository.findAllReq();
    }

    private LeaveRequestResponseDTO responseData(LeaveRequestEntity leaveRequest) {
        return new LeaveRequestResponseDTO(
                leaveRequest.getId(),
                leaveRequest.getStartDate(),
                leaveRequest.getEndDate(),
                leaveRequest.getLeaveStatus(),
                leaveRequest.getLeaveReason(),
                leaveRequest.getUser().getUserName(),
                leaveRequest.getLeaveTypeEntity().getTypeName()
        );
    }
}

package com.example.Leave_System_BE.Controller;

import com.example.Leave_System_BE.DTO.LeaveRequestDTO;
import com.example.Leave_System_BE.DTO.LeaveRequestResponseDTO;
import com.example.Leave_System_BE.Entity.LeaveRequestEntity;
import com.example.Leave_System_BE.EnumType.StatusEnum;
import com.example.Leave_System_BE.Service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("leave-request")
public class LeaveRequestController {
    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/create-request")
    public ResponseEntity<?> createRequest(@RequestBody LeaveRequestDTO leaveRequestDTO) {
        LeaveRequestEntity data = leaveRequestService.createLeaveReq(leaveRequestDTO);
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Create complete",
                "data", data
        ));
    }

    @PutMapping("/update-status-req/{id}")
    public ResponseEntity<?> updateStatusReq(@PathVariable("id") Long leaveRequestId,
                                          @RequestParam("status") StatusEnum status) {
        LeaveRequestResponseDTO updated = leaveRequestService.updateLeaveStatus(leaveRequestId, status);
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Status updated",
                "data", updated
        ));
    }

    @GetMapping("/get-approved-req")
    public ResponseEntity<?> getApprovedLeaves() {
        List<LeaveRequestEntity> list = leaveRequestService.getLeaveRequestsByStatus(StatusEnum.approved);
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Fetch approved leaves complete",
                "data", list
        ));
    }

    @GetMapping("/get-pending-req")
    public ResponseEntity<?> getPendingLeaves() {
        List<LeaveRequestEntity> list = leaveRequestService.getLeaveRequestsByStatus(StatusEnum.pending);
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Fetch approved leaves complete",
                "data", list
        ));
    }
}

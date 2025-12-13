package com.example.Leave_System_BE.Controller;

import com.example.Leave_System_BE.DTO.LeaveBalanceRequestDTO;
import com.example.Leave_System_BE.DTO.LeaveBalanceResponseDTO;
import com.example.Leave_System_BE.Entity.LeaveBalanceEntity;
import com.example.Leave_System_BE.Service.LeaveBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("leave-balance")
public class LeaveBalanceController {
    @Autowired
    private LeaveBalanceService leaveBalanceService;

    @PostMapping("/create-balance")
    public ResponseEntity<?> createBalance(@RequestBody LeaveBalanceRequestDTO leaveBalanceRequestDTO) {
        LeaveBalanceEntity data = leaveBalanceService.createLeaveBalance(leaveBalanceRequestDTO);
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Create Balance complete",
                "data", data
        ));
    }

    @GetMapping("/get-all-balance")
    public ResponseEntity<?> getAllBalance() {
        List<LeaveBalanceResponseDTO> data = leaveBalanceService.getBalanceData();
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Get All Balance complete",
                "data", data
        ));
    }
}

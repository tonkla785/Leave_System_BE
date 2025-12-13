package com.example.Leave_System_BE.Controller;

import com.example.Leave_System_BE.Entity.LeaveTypeEntity;
import com.example.Leave_System_BE.Service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("leave-type")
public class LeaveTypeController {
    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping("/get-type")
    public ResponseEntity<?> getType() {
        List<LeaveTypeEntity> data = leaveTypeService.getAllLeaveType();
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Create complete",
                "data", data
        ));
    }

    @PostMapping("/create-type")
    public ResponseEntity<?> createType() {
        List<LeaveTypeEntity> data = leaveTypeService.createLeaveTypes();
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Create complete",
                "data", data
        ));
    }
}

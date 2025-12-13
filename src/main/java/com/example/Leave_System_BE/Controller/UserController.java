package com.example.Leave_System_BE.Controller;

import com.example.Leave_System_BE.Entity.UserEntity;
import com.example.Leave_System_BE.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser() {
        UserEntity data = userService.createUser();
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Create complete",
                "data", data
        ));
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getUser(@RequestParam long id) {
        UserEntity data = userService.getUser(id);
        return ResponseEntity.ok(Map.of(
                "responseStatus", 200,
                "responseMessage", "Create complete",
                "data", data
        ));
    }
}

package com.example.Leave_System_BE.Service;

import com.example.Leave_System_BE.Entity.UserEntity;
import com.example.Leave_System_BE.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser() {
        UserEntity user = new UserEntity();
        user.setUserName("Kla");
        user.setUserEmail("tonkla785@gmail.com");
        user.setUserRole("Cooking");
        user.setUserDepartment("Intern");

        return userRepository.save(user);
    }

    public UserEntity getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException("ไม่พบข้อมูล userId = " + userId)
                );
    }

}

package com.huzaif.ExpenseTracker.controller;

import com.huzaif.ExpenseTracker.dto.UserDto;
import com.huzaif.ExpenseTracker.entity.User;
import com.huzaif.ExpenseTracker.service.ExpenseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    ExpenseTrackerService expenseTrackerService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(encodedPassword);
        expenseTrackerService.saveUser(user);
        return ResponseEntity.ok("User saved Successfully");
    }

}

package com.huzaif.ExpenseTracker.service;

import com.huzaif.ExpenseTracker.entity.User;
import com.huzaif.ExpenseTracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService{
    @Autowired
    UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByEmail(username);
    }
}

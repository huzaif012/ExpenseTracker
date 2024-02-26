package com.huzaif.ExpenseTracker.service;

import com.huzaif.ExpenseTracker.entity.User;

public interface ExpenseTrackerService {
    public User saveUser(User user);
    public User findUserByUsername(String username);
}

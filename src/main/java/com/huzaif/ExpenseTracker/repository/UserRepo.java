package com.huzaif.ExpenseTracker.repository;

import com.huzaif.ExpenseTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}

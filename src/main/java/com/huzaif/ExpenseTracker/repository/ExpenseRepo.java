package com.huzaif.ExpenseTracker.repository;

import com.huzaif.ExpenseTracker.entity.Expense;
import com.huzaif.ExpenseTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {
    public List<Expense> findByUser(User user);
}

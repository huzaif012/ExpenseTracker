package com.huzaif.ExpenseTracker.repository;

import com.huzaif.ExpenseTracker.entity.Income;
import com.huzaif.ExpenseTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepo extends JpaRepository<Income, Integer> {
    public List<Income> findByUser(User user);
}

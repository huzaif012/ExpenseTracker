package com.huzaif.ExpenseTracker.repository;

import com.huzaif.ExpenseTracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {
}

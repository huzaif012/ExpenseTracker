package com.huzaif.ExpenseTracker.repository;

import com.huzaif.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepo extends JpaRepository<Income, Integer> {
}

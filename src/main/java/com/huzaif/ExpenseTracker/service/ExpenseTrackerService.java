package com.huzaif.ExpenseTracker.service;

import com.huzaif.ExpenseTracker.entity.Expense;
import com.huzaif.ExpenseTracker.entity.Income;
import com.huzaif.ExpenseTracker.entity.User;

import java.util.List;
import java.util.Optional;

public interface ExpenseTrackerService {
    public User saveUser(User user);
    public User findUserByUsername(String username);
    public Income saveIncome(Income income);
    public List<Income> getIncomeHistory(User user);
    public void deleteIncome(int id);
    public Optional<Income> getIncomeById(int id);
    public Expense saveExpense(Expense expense);

    List<Expense> getExpenseByUser(User user);
}

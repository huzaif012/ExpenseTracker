package com.huzaif.ExpenseTracker.service;

import com.huzaif.ExpenseTracker.entity.Expense;
import com.huzaif.ExpenseTracker.entity.Income;
import com.huzaif.ExpenseTracker.entity.User;
import com.huzaif.ExpenseTracker.repository.ExpenseRepo;
import com.huzaif.ExpenseTracker.repository.IncomeRepo;
import com.huzaif.ExpenseTracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    IncomeRepo incomeRepo;
    @Autowired
    ExpenseRepo expenseRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByEmail(username);
    }
    public Income saveIncome(Income income){
        return incomeRepo.save(income);
    }

    @Override
    public List<Income> getIncomeHistory(User user) {
        return incomeRepo.findByUser(user);
    }

    @Override
    public void deleteIncome(int id) {
        incomeRepo.deleteById(id);
    }

    @Override
    public Optional<Income> getIncomeById(int id) {
        Optional<Income> optionalIncome = incomeRepo.findById(id);
        return optionalIncome;
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public List<Expense> getExpenseByUser(User user) {
        return expenseRepo.findByUser(user);
    }
}

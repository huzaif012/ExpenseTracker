package com.huzaif.ExpenseTracker.controller;

import com.huzaif.ExpenseTracker.dto.ExpenseDto;
import com.huzaif.ExpenseTracker.entity.Expense;
import com.huzaif.ExpenseTracker.entity.User;
import com.huzaif.ExpenseTracker.service.ExpenseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    ExpenseTrackerService expenseTrackerService;
    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@RequestBody Expense expense, Authentication authentication){
        User user = expenseTrackerService.findUserByUsername(authentication.getName());
        if(expense.getNameOfExpense().isEmpty()|| expense.getNameOfExpense()== null){
            expense.setNameOfExpense("New Expense");
        }
        expense.setUser(user);
        expenseTrackerService.saveExpense(expense);
        return ResponseEntity.ok("Expense added");
    }
    @GetMapping("/history")
    public ResponseEntity<List<ExpenseDto>> getIncomeList(Authentication authentication){
        User user = expenseTrackerService.findUserByUsername(authentication.getName());
        List<Expense> expenses = expenseTrackerService.getExpenseByUser(user);
        List<ExpenseDto> expenseDtos = expenses.stream().
                map(expense -> new ExpenseDto(expense.getId(),expense.getExpense(),expense.getNameOfExpense())).
                collect(Collectors.toList());
        return ResponseEntity.ok(expenseDtos);
    }

}

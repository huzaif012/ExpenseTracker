package com.huzaif.ExpenseTracker.controller;

import com.huzaif.ExpenseTracker.dto.IncomeDto;
import com.huzaif.ExpenseTracker.entity.Income;
import com.huzaif.ExpenseTracker.entity.User;
import com.huzaif.ExpenseTracker.service.ExpenseTrackerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/income")
public class IncomeController {
    @Autowired
    ExpenseTrackerService expenseTrackerService;

    @PostMapping("/add")
    public ResponseEntity<?> addIncome(@RequestBody Income income, Authentication authentication){

        User user = expenseTrackerService.findUserByUsername(authentication.getName());
        if(income.getNameOfIncome().isEmpty()||income.getNameOfIncome() == null){
            income.setNameOfIncome("New Income");
        }
        income.setUser(user);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime currentTime = LocalDateTime.now();
        String formattedTime = currentTime.format(formatter);
        income.setDateAndTime(LocalDateTime.parse(formattedTime, formatter));
        expenseTrackerService.saveIncome(income);
         return ResponseEntity.ok("Income added");
    }
    @GetMapping("/history")
    public ResponseEntity<List<IncomeDto>> getIncomeList(Authentication authentication){
        User user = expenseTrackerService.findUserByUsername(authentication.getName());
        List<Income> incomes = expenseTrackerService.getIncomeHistory(user);
        List<IncomeDto> incomeDTOs = incomes.stream()
                .map(income -> new IncomeDto(income.getId(), income.getIncome(), income.getDateAndTime(), income.getNameOfIncome()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(incomeDTOs);
    }
    @PutMapping("/edit/{incomeId}")
    public ResponseEntity<?> updateIncomeEntry(@PathVariable int incomeId, Authentication authentication, @RequestBody Income updatedIncome){
        User user = expenseTrackerService.findUserByUsername(authentication.getName());
        Optional<Income> optionalIncome = expenseTrackerService.getIncomeById(incomeId);
        if (optionalIncome.isEmpty() || !optionalIncome.get().getUser().equals(user)) {
            return ResponseEntity.notFound().build();
        }
        Income updateIncome = optionalIncome.get();
        updateIncome.setIncome(updatedIncome.getIncome());
        expenseTrackerService.saveIncome(updateIncome);
        return ResponseEntity.ok("Updated");
    }
    @DeleteMapping("/{incomeId}")
    public ResponseEntity<?> deleteIncome(@PathVariable int incomeId, Authentication authentication){
        User user = expenseTrackerService.findUserByUsername(authentication.getName());

        // Check if the income exists and belongs to the authenticated user
        Optional<Income> income = expenseTrackerService.getIncomeById(incomeId);
        if (income == null || !income.get().getUser().equals(user)) {
            return ResponseEntity.notFound().build();
        }

        // Delete the income
        expenseTrackerService.deleteIncome(incomeId);
        return ResponseEntity.ok("Deleted");
    }

}

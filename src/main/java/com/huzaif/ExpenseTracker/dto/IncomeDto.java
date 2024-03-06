package com.huzaif.ExpenseTracker.dto;

import com.huzaif.ExpenseTracker.entity.Income;

import java.time.LocalDateTime;

public class IncomeDto {
    private long id;
    private int income;
    private String nameOfIncome;
    private LocalDateTime time;

    // Constructors, getters, and setters
    public IncomeDto(){}

    public IncomeDto(long id, int income, LocalDateTime time, String nameOfIncome) {
        this.id = id;
        this.income = income;
        this.time = time;
        this.nameOfIncome = nameOfIncome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}


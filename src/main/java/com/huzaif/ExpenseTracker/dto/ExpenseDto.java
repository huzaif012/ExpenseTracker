package com.huzaif.ExpenseTracker.dto;

public class ExpenseDto {
    private long id;
    private int expense;
    private String nameOfExpense;

    ExpenseDto() {
    }

    public ExpenseDto(long id, int expense, String nameOfExpense) {
        this.id = id;
        this.expense = expense;
        this.nameOfExpense = nameOfExpense;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public String getNameOfExpense() {
        return nameOfExpense;
    }

    public void setNameOfExpense(String nameOfExpense) {
        this.nameOfExpense = nameOfExpense;
    }
}

package com.huzaif.ExpenseTracker.entity;

import jakarta.persistence.*;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int expense;
    private String nameOfExpense;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    Expense(){}

    public Expense(int expense, String nameOfExpense) {
        this.expense = expense;
        this.nameOfExpense = nameOfExpense;
    }

    public String getNameOfExpense() {
        return nameOfExpense;
    }

    public void setNameOfExpense(String nameOfExpense) {
        this.nameOfExpense = nameOfExpense;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.huzaif.ExpenseTracker.entity;

import jakarta.persistence.*;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int income;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    Income(){
    }

    public Income(int income) {
        this.income = income;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

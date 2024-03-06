package com.huzaif.ExpenseTracker.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int income;
    private LocalDateTime DateAndTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    Income(){
    }

    public Income(int income) {
        this.income = income;
    }

    public LocalDateTime getDateAndTime() {
        return DateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        DateAndTime = dateAndTime;
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

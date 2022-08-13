package com.dasitera.springexchange.infrastructure.entity;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private CurrencyCode fromCurrency;

    private CurrencyCode toCurrency;

    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @PrePersist
    private void onStart() {
        date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CurrencyCode getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(CurrencyCode fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public CurrencyCode getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(CurrencyCode toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

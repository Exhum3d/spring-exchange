package com.dasitera.springexchange.infrastructure.entity;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;

import javax.persistence.*;

@Entity
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private CurrencyCode fromCurrency;

    @Enumerated(EnumType.STRING)
    private CurrencyCode toCurrency;

    private double rate;

    @OneToOne(mappedBy = "exchange")
    private Transaction transaction;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "id=" + id +
                ", fromCurrency=" + fromCurrency +
                ", toCurrency=" + toCurrency +
                ", rate=" + rate +
                '}';
    }
}

package com.dasitera.springexchange.infrastructure.entity;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;

import javax.persistence.*;

/**
 * The Exchange entity which is in a one-to-one relationship with
 * the Transaction entity
 */
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

    public Exchange() {

    }

    public Exchange(CurrencyCode fromCurrency, CurrencyCode toCurrency, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exchange exchange = (Exchange) o;

        return id == exchange.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

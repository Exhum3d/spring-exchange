package com.dasitera.springexchange.rest.dto;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Transaction;

import java.util.Date;

public class TransactionDto {

    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public CurrencyCode fromCurrency;
    public CurrencyCode toCurrency;
    public double amount;

    public Date date;

    public Transaction toEntity() {
        Transaction transaction = new Transaction();

        transaction.setFirstName(firstName);
        transaction.setLastName(lastName);
        transaction.setEmail(email);
        transaction.setAmount(amount);
        transaction.setId(id);
        transaction.setFromCurrency(fromCurrency);
        transaction.setToCurrency(toCurrency);
        transaction.setDate(date);

        return transaction;
    }

    public static TransactionDto fromEntity(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();

        transactionDto.id = transaction.getId();
        transactionDto.firstName = transaction.getFirstName();
        transactionDto.lastName = transaction.getLastName();
        transactionDto.email = transaction.getEmail();
        transactionDto.fromCurrency = transaction.getFromCurrency();
        transactionDto.toCurrency = transaction.getToCurrency();
        transactionDto.amount = transaction.getAmount();
        transactionDto.date = transaction.getDate();

        return transactionDto;
    }

    public Transaction partialUpdateEntity(Transaction transaction) {
        this.id = transaction.getId();

        if (firstName != null) {
            transaction.setFirstName(firstName);
        }
        if (lastName != null) {
            transaction.setLastName(lastName);
        }
        if (fromCurrency != null) {
            transaction.setFromCurrency(fromCurrency);
        }
        if (toCurrency != null) {
            transaction.setToCurrency(toCurrency);
        }
        if (amount != 0.0d) {
            transaction.setAmount(amount);
        }

        return transaction;

    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", fromCurrency=" + fromCurrency +
                ", toCurrency=" + toCurrency +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}

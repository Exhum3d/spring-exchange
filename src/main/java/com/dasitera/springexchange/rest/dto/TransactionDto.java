package com.dasitera.springexchange.rest.dto;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.entity.Transaction;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Optional;

public class TransactionDto {

    @Autowired
    private static ExchangeRepository exchangeRepository;

    public int id;
    public int exchangeId;
    public String firstName;
    public String lastName;
    public CurrencyCode fromCurrency;
    public CurrencyCode toCurrency;
    public double rate;
    public String email;

    public double amount;

    public Exchange exchange;
    public Date date;


    public Transaction toEntity() {
        Transaction transaction = new Transaction();
        Exchange exchange = new Exchange();
        transaction.setFirstName(firstName);
        transaction.setLastName(lastName);
        transaction.setEmail(email);
        transaction.setAmount(amount);
        transaction.setId(id);
        transaction.getExchange().setId(exchangeId);
        transaction.getExchange().setRate(rate);
        transaction.getExchange().setToCurrency(toCurrency);
        transaction.getExchange().setFromCurrency(fromCurrency);
        transaction.setDate(date);

        return transaction;
    }

    public static TransactionDto fromEntity(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        Optional<Exchange> exchange = exchangeRepository.findById(transaction.getExchange().getId());
        transactionDto.id = transaction.getId();
        transactionDto.firstName = transaction.getFirstName();
        transactionDto.lastName = transaction.getLastName();
        transactionDto.email = transaction.getEmail();
        transactionDto.amount = transaction.getAmount();
        transactionDto.date = transaction.getDate();
        transactionDto.exchange.setId(transaction.getExchange().getId());
        transactionDto.exchange.setFromCurrency(transaction.getExchange().getFromCurrency());
        transactionDto.exchange.setToCurrency(transaction.getExchange().getToCurrency());
        transactionDto.exchange.setRate(transaction.getExchange().getRate());

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
        if (amount != 0.0d) {
            transaction.setAmount(amount);
        }

        return transaction;

    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "exchangeRepository=" + exchangeRepository +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", exchange=" + exchange +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}

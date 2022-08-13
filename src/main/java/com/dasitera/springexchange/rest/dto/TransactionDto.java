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
    private ExchangeRepository exchangeRepository;

    public int id;
    public int exchangeId;
    public String firstName;
    public String lastName;
    public String email;
    public ExchangeDto exchangeDto;
    public double amount;

    public Date date;

    public TransactionDto() {
    }

    public TransactionDto(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    public Transaction toEntity() {
        Transaction transaction = new Transaction();
        exchangeDto = new ExchangeDto();
        transaction.setFirstName(firstName);
        transaction.setLastName(lastName);
        transaction.setEmail(email);
        transaction.setAmount(amount);
        transaction.setId(id);
        transaction.setDate(date);

        return transaction;
    }

    public static TransactionDto fromEntity(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.id = transaction.getId();
        transactionDto.firstName = transaction.getFirstName();
        transactionDto.lastName = transaction.getLastName();
        transactionDto.email = transaction.getEmail();
        transactionDto.amount = transaction.getAmount();
        transactionDto.date = transaction.getDate();
        transactionDto.exchangeDto = ExchangeDto.fromEntity(transaction.getExchange());


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


}

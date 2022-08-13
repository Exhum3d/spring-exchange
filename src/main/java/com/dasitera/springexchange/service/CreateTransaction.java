package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.entity.Transaction;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateTransaction {
    private TransactionRepository transactionRepository;
    private ExchangeRepository exchangeRepository;

    public CreateTransaction(TransactionRepository transactionRepository,
                             ExchangeRepository exchangeRepository) {
        this.transactionRepository = transactionRepository;
        this.exchangeRepository = exchangeRepository;
    }

    public Transaction execute(Transaction transaction, int id) {
        Optional<Exchange> exchange = exchangeRepository.findById(id);
        if (exchange.isPresent()) {
            transaction.setExchange(exchange.get());
        }
        return transactionRepository.save(transaction);
    }
}

package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.entity.Transaction;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import com.dasitera.springexchange.service.interfaces.CreateTransaction;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateTransactionImpl implements CreateTransaction {
    private TransactionRepository transactionRepository;
    private ExchangeRepository exchangeRepository;

    public CreateTransactionImpl(TransactionRepository transactionRepository,
                                 ExchangeRepository exchangeRepository) {
        this.transactionRepository = transactionRepository;
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public Transaction execute(Transaction transaction, int id) {
        Optional<Exchange> exchange = exchangeRepository.findById(id);
        exchange.ifPresent(transaction::setExchange);

        return transactionRepository.save(transaction);
    }
}

package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.entity.Transaction;
import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTransaction {
    private TransactionRepository transactionRepository;

    public CreateTransaction(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}

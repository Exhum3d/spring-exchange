package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.entity.Transaction;
import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultTransaction {

    private final TransactionRepository transactionRepository;

    public ConsultTransaction(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> consultAll() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> consultById(int id) {
        return transactionRepository.findById(id);
    }
}

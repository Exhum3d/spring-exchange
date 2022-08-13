package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteTransaction {
    TransactionRepository transactionRepository;

    public DeleteTransaction(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void execute(int id) {
        transactionRepository.deleteById(id);
    }
}

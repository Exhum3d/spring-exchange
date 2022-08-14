package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.entity.Transaction;
import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import com.dasitera.springexchange.service.interfaces.ConsultTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultTransactionImpl implements ConsultTransaction {

    private final TransactionRepository transactionRepository;

    public ConsultTransactionImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> consultAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> consultById(int id) {
        return transactionRepository.findById(id);
    }
}

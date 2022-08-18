package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import com.dasitera.springexchange.service.interfaces.DeleteTransaction;
import org.springframework.stereotype.Service;

@Service
public class DeleteTransactionImpl implements DeleteTransaction {
    TransactionRepository transactionRepository;

    public DeleteTransactionImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void execute(int id) {

        transactionRepository.deleteById(id);
    }

}

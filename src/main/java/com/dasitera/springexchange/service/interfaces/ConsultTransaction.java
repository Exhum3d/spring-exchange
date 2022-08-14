package com.dasitera.springexchange.service.interfaces;

import com.dasitera.springexchange.infrastructure.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface ConsultTransaction {
    List<Transaction> consultAll();

    Optional<Transaction> consultById(int id);
}

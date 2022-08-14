package com.dasitera.springexchange.service.interfaces;

import com.dasitera.springexchange.infrastructure.entity.Transaction;

public interface CreateTransaction {
    Transaction execute(Transaction transaction, int id);
}

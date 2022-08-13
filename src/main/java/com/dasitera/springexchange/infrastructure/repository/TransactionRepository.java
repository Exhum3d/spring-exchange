package com.dasitera.springexchange.infrastructure.repository;

import com.dasitera.springexchange.infrastructure.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}

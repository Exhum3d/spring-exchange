package com.dasitera.springexchange.infrastructure.repository;

import com.dasitera.springexchange.infrastructure.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository contains all the useful methods for crud operations
 * ex: findAll(), findById(), save(), delete() etc.
 * Transaction repository must be an interface
 * <br>
 * JpaRepository uses two generics: 1st argument represents the type
 * of the entity, 2nd argument represents the type of the id field
 * of that entity.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}

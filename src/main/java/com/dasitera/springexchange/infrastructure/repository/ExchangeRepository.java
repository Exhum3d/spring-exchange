package com.dasitera.springexchange.infrastructure.repository;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

    /**
     * Method for a custom query:
     * Select * from Exchange where fromCurrency = :fromCurrency;
     */
    List<Exchange> findAllByFromCurrency(CurrencyCode fromCurrency);
}

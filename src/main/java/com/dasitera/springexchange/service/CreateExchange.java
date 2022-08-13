package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateExchange {

    private ExchangeRepository exchangeRepository;

    public CreateExchange(@Autowired ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    public Exchange execute(Exchange exchange) {

        return exchangeRepository.save(exchange);
    }
}

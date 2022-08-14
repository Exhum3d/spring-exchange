package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import com.dasitera.springexchange.service.interfaces.CreateExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateExchangeImpl implements CreateExchange {

    private ExchangeRepository exchangeRepository;

    public CreateExchangeImpl(@Autowired ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public Exchange execute(Exchange exchange) {

        return exchangeRepository.save(exchange);
    }
}

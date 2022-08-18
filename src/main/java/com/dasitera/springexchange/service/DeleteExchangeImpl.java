package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteExchangeImpl implements DeleteExchange {

    ExchangeRepository exchangeRepository;

    public DeleteExchangeImpl(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public void execute(int id) {

        exchangeRepository.deleteById(id);
    }
}

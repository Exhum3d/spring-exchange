package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import com.dasitera.springexchange.service.interfaces.ConsultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConsultExchangeImpl implements ConsultExchange {

    private final ExchangeRepository exchangeRepository;

    public ConsultExchangeImpl(@Autowired ExchangeRepository exchangeRepository) {
        this.exchangeRepository = Objects.requireNonNull(exchangeRepository);
    }

    @Override
    public Optional<Exchange> consultById(int id) {
        return exchangeRepository.findById(id);
    }

    @Override
    public List<Exchange> consultAll() {
        return exchangeRepository.findAll();
    }

    @Override
    public List<Exchange> consultAllFromCurrency(CurrencyCode currencyCode) {
        return exchangeRepository.findAllByFromCurrency(currencyCode);
    }
}

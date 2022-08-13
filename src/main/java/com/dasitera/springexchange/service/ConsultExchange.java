package com.dasitera.springexchange.service;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConsultExchange {

    private final ExchangeRepository exchangeRepository;

    public ConsultExchange(@Autowired ExchangeRepository exchangeRepository) {
        this.exchangeRepository = Objects.requireNonNull(exchangeRepository);
    }

    public Optional<Exchange> consultById(int id) {
        return exchangeRepository.findById(id);
    }

    public List<Exchange> consultAll() {
        return exchangeRepository.findAll();
    }

    public List<Exchange> consultAllFromCurrency(CurrencyCode currencyCode) {
        return exchangeRepository.findAllByFromCurrency(currencyCode);
    }
}

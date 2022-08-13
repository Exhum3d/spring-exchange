package com.dasitera.springexchange.bootstrap;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * BootstrapData class is resposible for initializing data
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final ExchangeRepository exchangeRepository;
    private final TransactionRepository transactionRepository;

    public BootstrapData(ExchangeRepository exchangeRepository,
                         TransactionRepository transactionRepository) {

        this.exchangeRepository = exchangeRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Exchange rate1 = new Exchange();
        rate1.setFromCurrency(CurrencyCode.USD);
        rate1.setToCurrency(CurrencyCode.RON);
        rate1.setRate(4.76);

    }
}

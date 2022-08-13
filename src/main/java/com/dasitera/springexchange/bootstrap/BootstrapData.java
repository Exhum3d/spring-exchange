package com.dasitera.springexchange.bootstrap;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.infrastructure.entity.Transaction;
import com.dasitera.springexchange.infrastructure.repository.ExchangeRepository;
import com.dasitera.springexchange.infrastructure.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * BootstrapData class is resposible for initializing data
 *
 * @Component annotations tells spring that the class is a
 * spring managed component
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

        Exchange rate1 = new Exchange(CurrencyCode.USD, CurrencyCode.RON, 4.76);
        Transaction transaction1 = new Transaction("Ion", "Tudor", "itudor@gmail.com", 40);

        transaction1.setExchange(rate1);

        exchangeRepository.save(rate1);
        transactionRepository.save(transaction1);


        Exchange rate2 = new Exchange(CurrencyCode.EUR, CurrencyCode.RON, 4.89);
        Transaction transaction2 = new Transaction("Mariana", "Mihalache", "mmihalache@gmail.com", 24);

        transaction2.setExchange(rate2);

        exchangeRepository.save(rate2);
        transactionRepository.save(transaction2);


    }
}

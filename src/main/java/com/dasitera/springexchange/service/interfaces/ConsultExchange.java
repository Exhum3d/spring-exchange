package com.dasitera.springexchange.service.interfaces;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;

import java.util.List;
import java.util.Optional;

public interface ConsultExchange {
    Optional<Exchange> consultById(int id);

    List<Exchange> consultAll();

    List<Exchange> consultAllFromCurrency(CurrencyCode currencyCode);
}

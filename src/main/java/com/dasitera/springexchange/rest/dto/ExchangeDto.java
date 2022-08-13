package com.dasitera.springexchange.rest.dto;


import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;

public class ExchangeDto {

    public int id;
    public CurrencyCode fromCurrency;
    public CurrencyCode toCurrency;
    public double rate;

    public Exchange toEntity() {
        Exchange exchange = new Exchange();

        exchange.setRate(rate);
        exchange.setFromCurrency(fromCurrency);
        exchange.setToCurrency(toCurrency);
        exchange.setId(id);

        return exchange;
    }

    public static ExchangeDto fromEntity(Exchange exchange) {
        ExchangeDto exchangeDto = new ExchangeDto();

        exchangeDto.id = exchange.getId();
        exchangeDto.fromCurrency = exchange.getFromCurrency();
        exchangeDto.toCurrency = exchange.getToCurrency();
        exchangeDto.rate = exchange.getRate();

        return exchangeDto;
    }

    public Exchange partialUpdateEntity(Exchange exchange) {
        this.id = exchange.getId();

        if (fromCurrency != null) {
            exchange.setFromCurrency(fromCurrency);
        }

        if (toCurrency != null) {
            exchange.setToCurrency(toCurrency);
        }

        if (rate != 0.0d) {
            exchange.setRate(rate);
        }

        return exchange;
    }

    @Override
    public String toString() {
        return "ExchangeDto{" +
                "id=" + id +
                ", fromCurrency=" + fromCurrency +
                ", toCurrency=" + toCurrency +
                ", rate=" + rate +
                '}';
    }
}

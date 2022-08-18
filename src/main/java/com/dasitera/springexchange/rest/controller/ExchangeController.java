package com.dasitera.springexchange.rest.controller;

import com.dasitera.springexchange.infrastructure.constant.CurrencyCode;
import com.dasitera.springexchange.infrastructure.entity.Exchange;
import com.dasitera.springexchange.rest.dto.ExchangeDto;
import com.dasitera.springexchange.service.DeleteExchange;
import com.dasitera.springexchange.service.interfaces.ConsultExchange;
import com.dasitera.springexchange.service.interfaces.CreateExchange;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping(value = "rates", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ExchangeController {

    private final CreateExchange createExchange;
    private final ConsultExchange consultExchange;
    private final DeleteExchange deleteExchange;

    public ExchangeController(CreateExchange createExchange,
                              ConsultExchange consultExchange,
                              DeleteExchange deleteExchange
    ) {
        this.createExchange = createExchange;
        this.consultExchange = consultExchange;
        this.deleteExchange = deleteExchange;
    }

    @GetMapping
    public List<ExchangeDto> getAll() {
        return consultExchange.consultAll().stream()
                .map(ExchangeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeDto> get(@PathVariable int id) {
        Optional<Exchange> optionalExchange = consultExchange.consultById(id);

        if (optionalExchange.isPresent()) {
            return ResponseEntity.ok(ExchangeDto.fromEntity(optionalExchange.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/currencies")
    public List<ExchangeDto> getAllFromCurrency(
            @RequestParam(value = "fromCurrency", required = false) String fromCurrency) {

        // Convert String to CurrencyCode enum type
        CurrencyCode currencyCode = CurrencyCode.valueOf(fromCurrency);

        return consultExchange.consultAllFromCurrency(currencyCode).stream()
                .map(ExchangeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeDto create(@RequestBody ExchangeDto request) {
        return ExchangeDto.fromEntity(createExchange.execute(request.toEntity()));
    }

    @PatchMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExchangeDto> updateExchange(
            @RequestBody ExchangeDto updateExchangeDto,
            @PathVariable("id") int id) {

        Optional<Exchange> exchange = consultExchange.consultById(id);

        if (exchange.isPresent()) {
            Exchange newExchange = createExchange.execute(updateExchangeDto.partialUpdateEntity(exchange.get()));
            return ResponseEntity.ok(ExchangeDto.fromEntity(newExchange));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ExchangeDto> deleteTransaction(@PathVariable("id") int id) {
        Optional<Exchange> exchange = consultExchange.consultById(id);

        if (exchange.isPresent()) {
            deleteExchange.execute(id);
            return ResponseEntity.ok(ExchangeDto.fromEntity(exchange.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.dasitera.springexchange.rest.controller;

import com.dasitera.springexchange.infrastructure.entity.Transaction;
import com.dasitera.springexchange.rest.dto.TransactionDto;
import com.dasitera.springexchange.service.ConsultTransaction;
import com.dasitera.springexchange.service.CreateTransaction;
import com.dasitera.springexchange.service.DeleteTransaction;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping(value = "transactions", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class TransactionController {
    private final CreateTransaction createTransaction;
    private final ConsultTransaction consultTransaction;
    private final DeleteTransaction deleteTransaction;

    public TransactionController(CreateTransaction createTransaction,
                                 ConsultTransaction consultTransaction,
                                 DeleteTransaction deleteTransaction) {
        this.createTransaction = createTransaction;
        this.consultTransaction = consultTransaction;
        this.deleteTransaction = deleteTransaction;
    }

    @GetMapping
    public List<TransactionDto> getAll() {
        return consultTransaction.consultAll().stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> get(@PathVariable int id) {
        Optional<Transaction> optionalTransaction = consultTransaction.consultById(id);

        if (optionalTransaction.isPresent()) {
            return ResponseEntity.ok(TransactionDto.fromEntity(optionalTransaction.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TransactionDto create(@RequestBody TransactionDto request) {
        return TransactionDto.fromEntity(createTransaction.execute(request.toEntity()));
    }

    @PatchMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDto> updateTransaction(
            @RequestBody TransactionDto updateTransactionDto,
            @PathVariable("id") int id) {

        Optional<Transaction> transaction = consultTransaction.consultById(id);

        if (transaction.isPresent()) {
            Transaction newTransaction = createTransaction.execute(updateTransactionDto.partialUpdateEntity(transaction.get()));
            return ResponseEntity.ok(TransactionDto.fromEntity(newTransaction));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TransactionDto> deleteTransaction(@PathVariable("id") int id) {
        Optional<Transaction> transaction = consultTransaction.consultById(id);

        if (transaction.isPresent()) {
            deleteTransaction.execute(id);
            return ResponseEntity.ok(TransactionDto.fromEntity(transaction.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

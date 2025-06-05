package com.itau.BackendChallenge.controller;

import com.itau.BackendChallenge.dto.TransactionCreateDTO;
import com.itau.BackendChallenge.model.Transaction;
import com.itau.BackendChallenge.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@Tag(name = "Transaction")
@RestController
@RequestMapping("/transacao")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @Operation(summary = "Create a new transaction")
    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody @Valid TransactionCreateDTO transactionDTO){
        if(transactionDTO.getDataHora().isAfter(OffsetDateTime.now()) || transactionDTO.getValor() < 0){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        this.service.addTransaction(new Transaction(transactionDTO.getValor(), transactionDTO.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Operation(summary = "Delete all transactions")
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTransactions(){
        this.service.clearTransactions();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

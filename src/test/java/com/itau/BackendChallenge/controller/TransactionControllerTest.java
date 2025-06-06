package com.itau.BackendChallenge.controller;

import com.itau.BackendChallenge.dto.TransactionCreateDTO;
import com.itau.BackendChallenge.model.Transaction;
import com.itau.BackendChallenge.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTransaction() {
        TransactionCreateDTO dto = new TransactionCreateDTO();
        dto.setValor(100.0);
        dto.setDataHora(OffsetDateTime.now().minusSeconds(10));

        ResponseEntity<Void> response = transactionController.createTransaction(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        ArgumentCaptor<Transaction> captor = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionService, times(1)).addTransaction(captor.capture());

        Transaction captured = captor.getValue();
        assertEquals(100.0, captured.getValor());
        assertEquals(dto.getDataHora(), captured.getDataHora());
    }

    @Test
    void createTransactionNegativeCase1() {
        TransactionCreateDTO dto = new TransactionCreateDTO();
        dto.setValor(50.0);
        dto.setDataHora(OffsetDateTime.now().plusSeconds(60));

        ResponseEntity<Void> response = transactionController.createTransaction(dto);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        verify(transactionService, never()).addTransaction(any());
    }

    @Test
    void createTransactionNegativeCase2() {
        TransactionCreateDTO dto = new TransactionCreateDTO();
        dto.setValor(-20.0);
        dto.setDataHora(OffsetDateTime.now());

        ResponseEntity<Void> response = transactionController.createTransaction(dto);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        verify(transactionService, never()).addTransaction(any());
    }

    @Test
    void deleteAllTransactions() {
        ResponseEntity<Void> response = transactionController.deleteAllTransactions();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(transactionService, times(1)).clearTransactions();
    }
}

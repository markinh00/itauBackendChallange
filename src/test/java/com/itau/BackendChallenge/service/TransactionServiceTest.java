package com.itau.BackendChallenge.service;

import com.itau.BackendChallenge.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService();
    }

    @Test
    void addTransaction() {
        Transaction transaction = new Transaction(100.0, OffsetDateTime.now());
        transactionService.addTransaction(transaction);

        DoubleSummaryStatistics stats = transactionService.getStatistics();
        assertEquals(1, stats.getCount());
        assertEquals(100.0, stats.getSum());
    }

    @Test
    void clearTransactions() {
        Transaction transaction = new Transaction(50.0, OffsetDateTime.now());
        transactionService.addTransaction(transaction);
        transactionService.clearTransactions();

        DoubleSummaryStatistics stats = transactionService.getStatistics();
        assertEquals(0, stats.getCount());
    }

    @Test
    void getStatistics() {
        Transaction recent = new Transaction(200.0, OffsetDateTime.now().minusSeconds(10));
        Transaction old = new Transaction(300.0, OffsetDateTime.now().minusSeconds(70));

        transactionService.addTransaction(recent);
        transactionService.addTransaction(old);

        DoubleSummaryStatistics stats = transactionService.getStatistics();

        assertEquals(1, stats.getCount());
        assertEquals(200.0, stats.getSum());
        assertEquals(200.0, stats.getAverage());
        assertEquals(200.0, stats.getMin());
        assertEquals(200.0, stats.getMax());
    }
}
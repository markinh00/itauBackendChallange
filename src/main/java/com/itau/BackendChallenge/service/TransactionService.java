package com.itau.BackendChallenge.service;

import com.itau.BackendChallenge.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService {
    private final Queue<Transaction> transactions = new ConcurrentLinkedDeque<>();

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void clearTransactions() {
        this.transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        return this.transactions.stream()
                .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }
}

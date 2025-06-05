package com.itau.BackendChallenge.model;

import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class Transaction {
    private Double valor;
    private OffsetDateTime dataHora;

    public Transaction(double valor, OffsetDateTime dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }
}

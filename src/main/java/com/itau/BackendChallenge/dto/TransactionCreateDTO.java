package com.itau.BackendChallenge.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class TransactionCreateDTO {
    @NotNull(message = "valor não pode ser nulo")
    private Double valor;

    @NotNull(message = "dataHora não pode ser nulo")
    private OffsetDateTime dataHora;
}

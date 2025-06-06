package com.itau.BackendChallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidTransactionException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> invalidTransactionException(MethodArgumentNotValidException e) {
        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
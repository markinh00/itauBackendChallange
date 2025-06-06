package com.itau.BackendChallenge.controller;

import com.itau.BackendChallenge.dto.StatisticsReadDTO;
import com.itau.BackendChallenge.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.DoubleSummaryStatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StatisticControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private StatisticController statisticController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getStatistics() {
        // Arrange
        DoubleSummaryStatistics mockStats = new DoubleSummaryStatistics();
        mockStats.accept(10.0);
        mockStats.accept(20.0);
        mockStats.accept(30.0);

        when(transactionService.getStatistics()).thenReturn(mockStats);

        // Act
        ResponseEntity<StatisticsReadDTO> response = statisticController.getStatistics();

        // Assert
        assertEquals(200, response.getStatusCodeValue());

        StatisticsReadDTO body = response.getBody();
        assertEquals(3, body.getCount());
        assertEquals(60.0, body.getSum());
        assertEquals(10.0, body.getMin());
        assertEquals(30.0, body.getMax());
        assertEquals(20.0, body.getAvg());
    }
}

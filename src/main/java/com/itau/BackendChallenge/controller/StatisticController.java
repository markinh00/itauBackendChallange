package com.itau.BackendChallenge.controller;

import com.itau.BackendChallenge.dto.StatisticsReadDTO;
import com.itau.BackendChallenge.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.DoubleSummaryStatistics;


@Tag(name = "Statistics")
@RestController
@RequestMapping("/estatistica")
public class StatisticController {
    @Autowired
    private TransactionService service;

    @Operation(summary = "Get the statistics of all transactions that occurred withing the past 60 seconds")
    @GetMapping
    public ResponseEntity<StatisticsReadDTO> getStatistics(){
        DoubleSummaryStatistics stats = this.service.getStatistics();
        return ResponseEntity.ok(new StatisticsReadDTO(stats));
    }
}

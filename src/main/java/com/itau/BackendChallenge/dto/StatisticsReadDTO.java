package com.itau.BackendChallenge.dto;

import lombok.Getter;
import java.util.DoubleSummaryStatistics;

@Getter
public class StatisticsReadDTO {
    private final long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;

    public StatisticsReadDTO(DoubleSummaryStatistics stats){
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
    }
}

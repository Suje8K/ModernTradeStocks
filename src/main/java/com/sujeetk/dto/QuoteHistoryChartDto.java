package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteHistoryChartDto {
    @JsonProperty(value = "chart")
    private QuoteHistoryDto chart;

    public QuoteHistoryDto getChart() {
        return chart;
    }

    public void setChart(QuoteHistoryDto chart) {
        this.chart = chart;
    }
}

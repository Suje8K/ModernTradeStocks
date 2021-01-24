package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Indicators {
    @JsonProperty(value = "quote")
    CandleData[] candleData;

    public CandleData[] getCandleData() {
        return candleData;
    }

    public void setCandleData(CandleData[] candleData) {
        this.candleData = candleData;
    }
}

package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaDto {
    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "symbol")
    private String symbol;

    @JsonProperty(value = "exchangeName")
    private String exchangeName;

    @JsonProperty(value = "instrumentType")
    private String instrumentType;

    @JsonProperty(value = "regularMarketTime")
    private long regularMarketTime;

    @JsonProperty(value = "exchangeTimezoneName")
    private String exchangeTimezoneName;

    @JsonProperty(value = "regularMarketPrice")
    private float regularMarketPrice;

    @JsonProperty(value = "chartPreviousClose")
    private float chartPreviousClose;

    @JsonProperty(value = "dataGranularity")
    private String dataGranularity;

    @JsonProperty(value = "range")
    private String range;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public long getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(long regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public float getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(float regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public float getChartPreviousClose() {
        return chartPreviousClose;
    }

    public void setChartPreviousClose(float chartPreviousClose) {
        this.chartPreviousClose = chartPreviousClose;
    }

    public String getDataGranularity() {
        return dataGranularity;
    }

    public void setDataGranularity(String dataGranularity) {
        this.dataGranularity = dataGranularity;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}

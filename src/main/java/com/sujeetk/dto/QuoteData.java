package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteData {
    @JsonProperty(value = "exchange")
    private String exchange;
    @JsonProperty(value = "shortname")
    private String shortname;
    @JsonProperty(value = "quoteType")
    private String quoteType;
    @JsonProperty(value = "symbol")
    private String symbol;
    @JsonProperty(value = "score")
    private float score;
    @JsonProperty(value = "typeDisp")
    private String typeDisp;
    @JsonProperty(value = "longname")
    private String longname;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getTypeDisp() {
        return typeDisp;
    }

    public void setTypeDisp(String typeDisp) {
        this.typeDisp = typeDisp;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }
}

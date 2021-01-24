package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {
    @JsonProperty(value = "count")
    private String quoteName;

    @JsonProperty(value = "quotes")
    private QuoteData[] quotesData;

    public String getQuoteName() {
        return quoteName;
    }

    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
    }

    public void setQuotesData(QuoteData[] quotesData) {
        this.quotesData = quotesData;
    }

    public QuoteData[] getQuotesData() {
        return quotesData;
    }
}

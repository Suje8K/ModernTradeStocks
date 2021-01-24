package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DividentDto {
    @JsonProperty(value = "amount")
    private float amount;

    @JsonProperty(value = "date")
    private long date;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}

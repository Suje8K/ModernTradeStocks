package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteHistoryDto {
    @JsonProperty(value = "error")
    private String error;

    @JsonProperty(value = "result")
    private ResultDto[] result;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ResultDto[] getResult() {
        return result;
    }

    public void setResult(ResultDto[] result) {
        this.result = result;
    }
}

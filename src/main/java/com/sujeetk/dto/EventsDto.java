package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class EventsDto {
    @JsonProperty(value = "dividends")
    private Map<String, DividentDto> timestamp;

    public Map<String, DividentDto> getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Map<String, DividentDto> timestamp) {
        this.timestamp = timestamp;
    }
}

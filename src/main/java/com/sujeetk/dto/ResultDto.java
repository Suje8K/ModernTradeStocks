package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDto {
    @JsonProperty(value = "meta")
    private MetaDto meta;

    @JsonProperty(value = "timestamp")
    private long[] timestamp;

    @JsonProperty(value = "events")
    private EventsDto events;

    @JsonProperty(value = "indicators")
    private Indicators indicators;

    public MetaDto getMeta() {
        return meta;
    }

    public void setMeta(MetaDto meta) {
        this.meta = meta;
    }

    public long[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long[] timestamp) {
        this.timestamp = timestamp;
    }

    public EventsDto getEvents() {
        return events;
    }

    public void setEvents(EventsDto events) {
        this.events = events;
    }

    public Indicators getIndicators() {
        return indicators;
    }

    public void setIndicators(Indicators indicators) {
        this.indicators = indicators;
    }
}

package com.sujeetk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CandleData {
    @JsonProperty(value = "low")
    float[] low;

    @JsonProperty(value = "high")
    float[] high;

    @JsonProperty(value = "close")
    float[] close;

    @JsonProperty(value = "volume")
    float[] volume;

    @JsonProperty(value = "open")
    float[] open;

    public float[] getLow() {
        return low;
    }

    public void setLow(float[] low) {
        this.low = low;
    }

    public float[] getHigh() {
        return high;
    }

    public void setHigh(float[] high) {
        this.high = high;
    }

    public float[] getClose() {
        return close;
    }

    public void setClose(float[] close) {
        this.close = close;
    }

    public float[] getVolume() {
        return volume;
    }

    public void setVolume(float[] volume) {
        this.volume = volume;
    }

    public float[] getOpen() {
        return open;
    }

    public void setOpen(float[] open) {
        this.open = open;
    }
}

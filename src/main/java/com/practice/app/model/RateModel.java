package com.practice.app.model;
import java.math.BigDecimal;
import java.util.Map;

public class RateModel {
    //private String disclaimer;
    //private String license;
    //private int timestamp;
    //private String base;

    private Map<String, BigDecimal> rates;

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}

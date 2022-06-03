package com.project.exchangeratesalfa.model;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyRate {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String, Double> rates;
}

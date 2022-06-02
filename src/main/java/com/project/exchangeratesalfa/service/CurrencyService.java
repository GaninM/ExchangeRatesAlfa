package com.project.exchangeratesalfa.service;

import com.project.exchangeratesalfa.model.CurrencyRate;
import org.springframework.http.ResponseEntity;

public interface CurrencyService {
    ResponseEntity<CurrencyRate> getCurrency(String date, String base);
}

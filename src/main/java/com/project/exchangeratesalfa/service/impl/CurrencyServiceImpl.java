package com.project.exchangeratesalfa.service.impl;

import com.project.exchangeratesalfa.client.CurrencyClient;
import com.project.exchangeratesalfa.model.CurrencyRate;
import com.project.exchangeratesalfa.service.CurrencyService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Data
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyClient currencyClient;

    private final String apiKey;

    public CurrencyServiceImpl(CurrencyClient currencyClient, @Value("${currency.app.id}") String apiKey) {
        this.currencyClient = currencyClient;
        this.apiKey = apiKey;
    }

    @Override
    public ResponseEntity<CurrencyRate> getCurrency(String date, String base) {
        return currencyClient.getCurrency(date, apiKey, base);
    }
}

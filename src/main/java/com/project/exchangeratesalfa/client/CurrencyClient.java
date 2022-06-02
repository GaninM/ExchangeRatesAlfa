package com.project.exchangeratesalfa.client;

import com.project.exchangeratesalfa.model.CurrencyRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currencyClient", url = "${openexchangerates.url}")
public interface CurrencyClient {
    @GetMapping("/{date}.json")
    ResponseEntity<CurrencyRate> getCurrency(@PathVariable("date") String date, @RequestParam("app_id") String id,
                                             @RequestParam(value = "base", defaultValue = "USD") String base);
}

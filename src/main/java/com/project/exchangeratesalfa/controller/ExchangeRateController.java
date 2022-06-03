package com.project.exchangeratesalfa.controller;

import com.project.exchangeratesalfa.service.GifDependingOnCurrency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class ExchangeRateController {

    private final GifDependingOnCurrency gifDependingOnCurrency;

    public ExchangeRateController(GifDependingOnCurrency gifDependingOnCurrency) {
        this.gifDependingOnCurrency = gifDependingOnCurrency;
    }

    @GetMapping("/gif")
    public ResponseEntity<byte[]> getGifByRate(@RequestParam("base") String base) {
        return gifDependingOnCurrency.getGifUrlByCurrency(base);
    }

    @GetMapping("/*")
    public ResponseEntity<byte[]> getGifByCurrency() {
        return gifDependingOnCurrency.getGifUrlByCurrency("USD");
    }
}

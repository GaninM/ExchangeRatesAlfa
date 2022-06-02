package com.project.exchangeratesalfa.controller;

import com.project.exchangeratesalfa.service.GifDependingOnCurrency;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currency")
public class ExchangeRateController {

    private final GifDependingOnCurrency gifDependingOnCurrency;

    @GetMapping("/gif")
    public ResponseEntity<byte[]> getGifByRate(@RequestParam("base") String base) {
        return gifDependingOnCurrency.getGifUrlByCurrency(base);
    }

}

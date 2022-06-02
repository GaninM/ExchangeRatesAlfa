package com.project.exchangeratesalfa.service;

import org.springframework.http.ResponseEntity;

public interface GifDependingOnCurrency {
    ResponseEntity<byte[]> getGifUrlByCurrency(String base);
}

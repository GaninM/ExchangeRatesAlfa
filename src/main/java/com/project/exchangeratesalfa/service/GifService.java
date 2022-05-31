package com.project.exchangeratesalfa.service;

import org.springframework.http.ResponseEntity;

public interface GifService {

    ResponseEntity<?> getRandomGif(String tag);
}

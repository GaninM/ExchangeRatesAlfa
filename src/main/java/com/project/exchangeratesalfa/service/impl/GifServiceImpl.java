package com.project.exchangeratesalfa.service.impl;

import com.project.exchangeratesalfa.client.GifClient;
import com.project.exchangeratesalfa.service.GifService;
import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Data
@Service
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;

    @Value("${gif.api.key}")
    private String apiKey;

    @Override
    public ResponseEntity<?> getRandomGif(String tag) {
        return gifClient.getRandomGif(apiKey, tag);
    }
}

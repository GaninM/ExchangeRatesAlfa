package com.project.exchangeratesalfa.service.impl;

import com.project.exchangeratesalfa.client.GifClient;
import com.project.exchangeratesalfa.model.Gif;
import com.project.exchangeratesalfa.service.GifService;
import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Data
@Service
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;

    private String apiKey;

    public GifServiceImpl(GifClient gifClient, @Value("${gif.api.key}") String apiKey) {
        this.gifClient = gifClient;
        this.apiKey = apiKey;
    }

    public ResponseEntity<Gif> getGif(String tag) {
        return gifClient.getRandomGif(apiKey, tag);
    }
}

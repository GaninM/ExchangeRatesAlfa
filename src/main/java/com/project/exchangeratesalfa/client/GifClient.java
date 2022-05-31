package com.project.exchangeratesalfa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gifClient", url = "https://api.giphy.com/v1/gifs")
public interface GifClient {

    @GetMapping(value = "/random")
    ResponseEntity<?> getRandomGif(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag);
}

package com.project.exchangeratesalfa.client;

import com.project.exchangeratesalfa.model.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gifClient", url = "${giphy.url}")
public interface GifClient {
    @GetMapping(value = "/random")
    ResponseEntity<Gif> getRandomGif(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag);
}

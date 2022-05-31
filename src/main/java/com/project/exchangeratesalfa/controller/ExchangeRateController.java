package com.project.exchangeratesalfa.controller;

import com.project.exchangeratesalfa.service.GifService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
//TODO переименовать мапинг
@RequestMapping("/er")
public class ExchangeRateController {

    private final GifService gifService;

    @GetMapping("/gif")
    public ResponseEntity<?> getGifByRate(@RequestParam("tag") String tag) {
        return gifService.getRandomGif(tag);
    }
}

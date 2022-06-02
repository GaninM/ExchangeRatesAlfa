package com.project.exchangeratesalfa.service;

import com.project.exchangeratesalfa.model.Gif;
import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<Gif> getGif(String tag);
}

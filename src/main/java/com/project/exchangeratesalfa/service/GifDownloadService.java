package com.project.exchangeratesalfa.service;

import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface GifDownloadService {

    ResponseEntity<byte[]> getGifByUrl(URI url);

}

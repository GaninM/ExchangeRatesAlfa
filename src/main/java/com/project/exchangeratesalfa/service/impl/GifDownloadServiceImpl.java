package com.project.exchangeratesalfa.service.impl;

import com.project.exchangeratesalfa.client.GifDownloadClient;
import com.project.exchangeratesalfa.service.GifDownloadService;
import com.project.exchangeratesalfa.service.GifService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Data
@Service
public class GifDownloadServiceImpl implements GifDownloadService {

    private final GifDownloadClient gifDownloadClient;
    private final GifService gifService;

    @Autowired
    public GifDownloadServiceImpl(GifDownloadClient gifDownloadClient, GifService gifService) {
        this.gifDownloadClient = gifDownloadClient;
        this.gifService = gifService;
    }

    @Override
    public ResponseEntity<byte[]> getGifByUrl(URI url) {
        return gifDownloadClient.getGifByUrl(url);
    }

}

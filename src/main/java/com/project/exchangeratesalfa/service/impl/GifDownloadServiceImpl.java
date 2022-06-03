package com.project.exchangeratesalfa.service.impl;

import com.project.exchangeratesalfa.client.GifDownloadClient;
import com.project.exchangeratesalfa.model.Gif;
import com.project.exchangeratesalfa.service.GifDownloadService;
import com.project.exchangeratesalfa.service.GifService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public String getGifUrlByTag(String tag) {
        Gif gif = gifService.getGif(tag).getBody();
        Map data = (Map) Objects.requireNonNull(gif).getData().get("images");
        data = (Map) data.get("original");
        return (String) data.get("url");
    }
}

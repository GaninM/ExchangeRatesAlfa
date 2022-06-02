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
        //Помещаем боди в дату в Gif
        Gif gif = gifService.getGif(tag).getBody();
        System.out.println(gif.toString());

        //TODO переделать мапы в один стрим , который выведет url и присвоет String

        // gif.getData().entrySet().stream()
        //       .filter(e -> e.getKey().equals("images"))
//                .map(e -> {
//                    String key = e.getKey();
//                    Object value = e.getValue();
//                    Map<String, Object> map = new HashMap<>();
//                    map.put(key, value);
//                    return map;
//                })
//
        //.filter(e -> e.getKey().equals("hd"))
        //.forEach(e -> System.out.println(e));
//
//
//
        Map<String, Object> secondData = (Map<String, Object>) gif.getData().get("images");
        System.out.println(secondData.toString());
        Map<String, Object> thirtyData = (Map<String, Object>) secondData.get("downsized_large");
        System.out.println(thirtyData.toString());
        //достаем url
        String url = (String) thirtyData.get("url");
        System.out.println(url);
//        //Создаем URI для получения гиф по url
//        URI basePathUri = URI.create(url);
//        //загружаем гиф на страницу

        //return gifDownloadService.getGifByUrl(basePathUri);
        return url;
    }

}

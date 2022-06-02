package com.project.exchangeratesalfa.controller;

import com.project.exchangeratesalfa.model.Gif;
import com.project.exchangeratesalfa.service.GifDownloadService;
import com.project.exchangeratesalfa.service.GifService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
//TODO переименовать мапинг
@RequestMapping("/er")
public class ExchangeRateController {

    private final GifService gifService;
    private final GifDownloadService gifDownloadService;

    @GetMapping("/gif")
    public ResponseEntity<byte[]> getGifByRate(@RequestParam("tag") String tag) {
        //Помещаем боди в дату в Gif
        Gif gif = gifService.getGif(tag).getBody();
        System.out.println(gif.toString());
        Map<String, Object> secondData = (Map<String, Object>) gif.getData().get("images");
        System.out.println(secondData.toString());
        Map<String, Object> thirtyData = (Map<String, Object>) secondData.get("fixed_height_downsampled");
        System.out.println(thirtyData.toString());
        //достаем url
        String url = (String) thirtyData.get("url");
        System.out.println(url);
        //Создаем URI для получения гиф по url
        URI basePathUri = URI.create(url);
        //загружаем гиф на страницу
        return gifDownloadService.getGifByUrl(basePathUri);
    }

}

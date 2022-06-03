package com.project.exchangeratesalfa.service.impl;

import com.project.exchangeratesalfa.model.CurrencyRate;
import com.project.exchangeratesalfa.service.CurrencyService;
import com.project.exchangeratesalfa.service.GifDependingOnCurrency;
import com.project.exchangeratesalfa.service.GifDownloadService;
import com.project.exchangeratesalfa.service.GifService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

@Data
@Service
public class GifDependingOnCurrencyImpl implements GifDependingOnCurrency {

    private final GifService gifService;
    private final GifDownloadService gifDownloadService;

    private final CurrencyService currencyService;

    @Autowired
    public GifDependingOnCurrencyImpl(GifService gifService, GifDownloadService gifDownloadService, CurrencyService currencyService) {
        this.gifService = gifService;
        this.gifDownloadService = gifDownloadService;
        this.currencyService = currencyService;
    }

    @Override
    public ResponseEntity<byte[]> getGifUrlByCurrency(String base) {
        if (checkBaseOnValid(base)) {
            throw new RuntimeException("Код должен состоять из 3-х символов");
        }
        String dateToday = dateFormatSetting(0);
        String dateYesterday = dateFormatSetting(1);
        double rateToday = getCurrencyByBaseAndDate(dateToday, base);
        double rateYesterday = getCurrencyByBaseAndDate(dateYesterday, base);
        String tag = (rateToday > rateYesterday) ? "rich" : "broke";
        URI uriPath = URI.create(gifDownloadService.getGifUrlByTag(tag));
        return gifDownloadService.getGifByUrl(uriPath);
    }

    private double getCurrencyByBaseAndDate(String date, String base) {
        CurrencyRate currency = currencyService.getCurrency(date, base.toUpperCase()).getBody();
        return Objects.requireNonNull(currency).getRates().get("RUB");
    }

    private String dateFormatSetting(int daysAgo) {
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(daysAgo);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(localDateTime);
    }

    private boolean checkBaseOnValid(String base) {
        return base.length() != 3;
    }
}

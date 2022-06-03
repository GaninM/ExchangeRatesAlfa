package com.project.exchangeratesalfa.service;

import com.project.exchangeratesalfa.model.CurrencyRate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    @DisplayName("Проверка корректности ответа от currency api")
    void getCurrency() {
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now());
        ResponseEntity<CurrencyRate> response = currencyService.getCurrency(date,"USD");
        assertAll(
                () -> assertEquals(200, response.getStatusCodeValue()),
                () -> assertNotNull(response.getBody()),
                () -> assertNotNull(Objects.requireNonNull(response.getBody()).getRates().get("RUB"))
        );
    }

}

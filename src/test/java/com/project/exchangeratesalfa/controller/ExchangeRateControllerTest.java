package com.project.exchangeratesalfa.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ExchangeRateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Получение Gif без явного указания валюты")
    void getResponse() throws Exception {
        mockMvc.perform(get("/currency/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Получение GIF с указанием валюты USD")
    void getGif() throws Exception {
        mockMvc.perform(get("/currency/gif")
                        .param("base", "USD"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF));
    }

    @Test()
    @DisplayName("проверка на некоректнО введную валюту(Колличество символов != 3)")
    void getGifBadGateWay() {
        assertThrows(RuntimeException.class,
                () -> mockMvc.perform(get("/currency/gif")
                                .param("base", "BADBASE"))
                        .andExpect(status().isBadRequest()));
    }
}


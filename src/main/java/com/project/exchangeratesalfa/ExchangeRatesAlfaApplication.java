package com.project.exchangeratesalfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeRatesAlfaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRatesAlfaApplication.class, args);
    }
}

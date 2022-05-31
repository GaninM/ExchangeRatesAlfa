package com.project.exchangeratesalfa.model;

import lombok.Builder;
import lombok.Data;

//TODO нужен ли билдер?
@Builder
@Data
public class Gif {

    private String apiKey;
    private String tag;
    private String rating;
}

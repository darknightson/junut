package com.example.junit.mock;

import com.example.junit.chapter_10.Http;

import java.io.IOException;

public class HttpImplTest implements Http {
    @Override
    public String get(String url) throws IOException {
        return "{\"address\":{"
                + "\"house_number\":\"324\","
                + "\"road\":\"North Tejon Street\","
                + "\"city\":\"Colorado Springs\","
                + "\"state\":\"Colorado\","
                + "\"postcode\":\"80903\","
                + "\"country_code\":\"us\"}"
                + "}";
    }
}

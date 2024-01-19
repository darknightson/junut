package com.example.junit.chapter_10;

import java.io.IOException;

@FunctionalInterface
public interface Http {

    String get(String url) throws IOException;
}

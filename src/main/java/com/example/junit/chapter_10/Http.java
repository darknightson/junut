package com.example.junit.chapter_10;

import java.io.IOException;

public interface Http {

    String get(String url) throws IOException;
}

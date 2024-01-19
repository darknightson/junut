package com.example.junit.basic.chapter_01;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({METHOD, TYPE})
@Retention(RUNTIME)
@Test
@Tag("fast")
public @interface FastTest {
}

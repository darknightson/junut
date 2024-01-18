package com.example.junit.basic.chapter_01;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    /*
    @BeforeAll : 모든 테스트가 실행되기 전에 딱 한번만 실행된다. 정적 메서드
    @AfterAll : 모든 테스트가 실행된 후에 딱 한번만 실행된다. 정적 메서드
    @BeforeEach : 각각의 테스트가 실행되기 전에 실행된다.
    @AfterEach : 각각의 테스트가 실행된 후에 실행된다.
    @Disabled : 테스트를 실행하지 않는다.
     */

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

    @Test
    void create() {
        System.out.println("create");
    }

    @Test
    void create1() {
        System.out.println("create1");
    }
}
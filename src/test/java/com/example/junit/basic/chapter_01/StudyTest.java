package com.example.junit.basic.chapter_01;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// 이거는 언더 스코어를 공백을 바꿔준다 ( 메서드 이름 )
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    /*
    @BeforeAll : 모든 테스트가 실행되기 전에 딱 한번만 실행된다. 정적 메서드
    @AfterAll : 모든 테스트가 실행된 후에 딱 한번만 실행된다. 정적 메서드
    @BeforeEach : 각각의 테스트가 실행되기 전에 실행된다.
    @AfterEach : 각각의 테스트가 실행된 후에 실행된다.
    @Disabled : 테스트를 실행하지 않는다.

    Junit5 부터는 @BeforeClass, @AfterClass, @Before, @After 어노테이션을 사용하지 않는다.
    Junit 테스트 이름 표시하기

    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    - 메서드와 클래스 래퍼런스를 사용해서 테스트 이름을 표기하는 방법을 설정한다.
    - 기본 구현체로 ReplaceUnderscores 구현체를 제공한다.

    @DisplayName
    - 메서드 별로 테스트 이름을 표기하는 방법을 설정한다.
    - @DisplayNameGeneration 보다 우선순위가 높다.
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

    /*
    test 메서드 이름을 표시하는 방법
     */
    @Test
    void displayName() {
        System.out.println("displayName");
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
package com.example.junit.basic.chapter_01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void 스터디를_처음_만들면_상태값이_DRAFT_여야_한다() {
        Study study = new Study();
        assertNotNull(study);

        System.out.println("study.getStatus() = " + study.getStatus());
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."), // 실패 했을 경우 메시지를 람다로 만들어서 사용할 수 있다.
                () -> assertThat(study.getStatus()).isEqualTo(StudyStatus.DRAFT)
        );
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT 여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."); // 실패 했을 경우 메시지를 람다로 만들어서 사용할 수 있다.
        assertThat(study.getStatus()).isEqualTo(StudyStatus.DRAFT);

    }

    @Test
    //@EnabledOnOs({ OS.MAC, OS.LINUX}) // 맥에서만 아래 테스트 실행
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11}) // 특정 자바 버전에서만 실행
    @EnabledOnOs(value = OS.MAC) // 맥에서만 아래 테스트 실행
    void 조건에_따라_테스트_실행하기() {
        // assumeTrue : 테스트를 실행할지 말지 결정하는 메서드
        // 테스트 환경이 로컬일 경우에만 아래 테스트 코드를 실행한다.
        // 아래 어줌은 확인할 필요가 있다.
        System.out.println("System.getenv() = " + System.getenv());
        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));

        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    void create1() {
        System.out.println("create1");
    }
}
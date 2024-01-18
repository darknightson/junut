package com.example.junit.basic.chapter_01;

import org.assertj.core.api.Assertions;
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
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void 스터디를_처음_만들면_상태값이_DRAFT_여야_한다() {
        Study study = new Study();
        assertNotNull(study);

        System.out.println("study.getStatus() = " + study.getStatus());
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."), // 실패 했을 경우 메시지를 람다로 만들어서 사용할 수 있다.
                () -> Assertions.assertThat(study.getStatus()).isEqualTo(StudyStatus.DRAFT)
        );
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT 여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT 여야 한다."); // 실패 했을 경우 메시지를 람다로 만들어서 사용할 수 있다.
        Assertions.assertThat(study.getStatus()).isEqualTo(StudyStatus.DRAFT);

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
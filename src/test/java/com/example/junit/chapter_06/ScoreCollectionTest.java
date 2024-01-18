package com.example.junit.chapter_06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Right-BICEP
 * 결과가 올바른가? RIGHT ( 개발자가 예상한 대로 동작하는가? )
 * 결과가 올바르지 않은가? WRONG ( 개발자가 예상하지 못한 결과가 나오는가? )
 * B : 경계 조건은 맞는가?
 */
class ScoreCollectionTest {

    ScoreCollection collection;

    // 초기 작업 준비
    @BeforeEach
    void setUp() {
        collection = new ScoreCollection();
    }

    @Test
    void 스코어_컬렉션에_null_값을_넣으면_예외가_발생한다() {

        // given (준비)

        // when (실행) // then (단언 assert)
        assertThatThrownBy(() -> collection.add(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스코어_컬렉션_클래스에_데이터를_넣지_않으면_arithmeticMean_메서드를_호출하면_0이_나와야_한다() {

        // given (준비)
        ScoreCollection scoreCollection = new ScoreCollection();
        // when (실행) // then (단언 assert)
        assertThat(scoreCollection.arithmeticMean()).isEqualTo(0);
    }

    @Test
    void 테스트() {

        // given (준비) // when (실행)
        collection.add(() -> Integer.MAX_VALUE);
        //collection.add(() -> 1);

        // then (단언 assert)
        assertThat(collection.arithmeticMean()).isGreaterThan(0);
    }

    // 경계 조건에서는 CORRECT를 기억하라 ( Right-[B]ICEP )
    /*
    CORRECT 약어는 잠재적인 경계 조건을 기억하는 데 도움을 준다. 각 항목에 대해 유사한 조건을 테스트 하려는 메서드에 해당하며, 이 조건을 위반 했을때
    어떤 일이 일어날 수 있는지 고려해 보자

    [C]onformance(준수) : 값이 기대한 양식을 따르는가?
    [O]rdering(순서)    : 값의 집합이 적절하게 정렬되거나 정렬되지 않았나?
    [R]ange(범위)       : 이성적인 최소값 최대값 안에 있는가?
    [R]eference(참조)   : 코드 자체에서 통제할 수 없는 어떤 외부 참조를 포함하고 있는가?
    [E]xistence(존재)   : 값이 존재하는가? null이 아닌가?, 0이 아니거나 , 집합이 존재하는가?
    [C]ardinality(기수) : 정확히 충분한 값들이 있는가?
    [T]ime(시간)        : 모든 것이 순서대로 일어나는가? 정확한 시간에? 정시에?
     */

    // ---------------------------------- //
    /*
    Right-B[I]CEP : 역 관계를 검사할 수 있는가?
     */
}
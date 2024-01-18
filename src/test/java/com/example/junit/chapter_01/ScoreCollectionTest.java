package com.example.junit.chapter_01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ScoreCollectionTest {

    @Test
    void 스코어_컬렉션에_값을_넣고_나누면_결과가_통과한다() {

        // given (준비)
        ScoreCollection collection = new ScoreCollection();

        // when (실행)
        collection.add(() -> 5);
        collection.add(() -> 7);

        int actualResult = collection.arithmeticMean();

        // then (단언 assert)
        assertThat(actualResult).isEqualTo(6);
    }

    @Test
    void 스코어_컬렉션에_값을_넣고_나누면_결과가_통과한다_익명_클래스로_Scoreable를_구현한다() {

        // given (준비)
        ScoreCollection collection = new ScoreCollection();

        // when (실행)
        collection.add(new Scoreable() {
            @Override
            public int getScore() {
                return 5;
            }
        });

        collection.add(new Scoreable() {
            @Override
            public int getScore() {
                return 7;
            }
        });

        List<Scoreable> scores = collection.getScores();
        System.out.println("scores = " + scores.size());

        scores.forEach(scoreable -> System.out.println("scoreable = " + scoreable.getScore()));

        int actualResult = collection.arithmeticMean();
        // then (단언 assert)
        assertThat(actualResult).isEqualTo(6);
    }





}
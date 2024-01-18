package com.example.junit.chapter_01;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScoreCollection {

    private List<Scoreable> scores = new ArrayList<>();

    public void add(Scoreable scoreable) {
        if (scoreable == null) throw new IllegalArgumentException();
        scores.add(scoreable);
    }

    public int arithmeticMean() {
        int total = scores.stream()
                .mapToInt(Scoreable::getScore)
                .sum();
        return total / scores.size();
    }
}

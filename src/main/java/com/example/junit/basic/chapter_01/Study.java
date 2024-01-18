package com.example.junit.basic.chapter_01;

import lombok.Getter;

public class Study {
    private StudyStatus status;
    private int limit;

    public Study() {
        this.status = StudyStatus.DRAFT;
    }

    public Study(int limit) {
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public int getLimit() {
        return limit;
    }
}

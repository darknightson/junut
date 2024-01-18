package com.example.junit.basic.chapter_01;

import lombok.Getter;

public class Study {
    private StudyStatus status;

    public Study() {
        this.status = StudyStatus.DRAFT;
    }

    public StudyStatus getStatus() {
        return status;
    }
}

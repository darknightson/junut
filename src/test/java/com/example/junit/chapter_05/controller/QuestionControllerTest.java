/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package com.example.junit.chapter_05.controller;

import com.example.junit.chapter_05.domain.Question;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class QuestionControllerTest {

   private QuestionController controller;

   @BeforeEach
   public void create() {
      controller = new QuestionController();
      controller.deleteAll();
   }

   @Test
   public void findsPersistedQuestionById() {
      int id = controller.addBooleanQuestion("question text");

      Question question = controller.find(id);

      assertThat(question.getText(), equalTo("question text"));
   }

   @Test
   public void questionAnswersDateAdded() {
      Instant now = new Date().toInstant();
      controller.setClock(Clock.fixed(now, ZoneId.of("America/Denver")));
      int id = controller.addBooleanQuestion("text");

      Question question = controller.find(id);

      Assertions.assertThat(question.getCreateTimestamp()).isEqualTo(now);
   }

   @Test
   public void answersMultiplePersistedQuestions() {
      controller.addBooleanQuestion("q1");
      controller.addBooleanQuestion("q2");
      controller.addPercentileQuestion("q3", new String[] { "a1", "a2"});
      
      List<Question> questions = controller.getAll();
      
      assertThat(
         questions.stream().map(Question::getText).collect(Collectors.toList()), 
         equalTo(Arrays.asList("q1", "q2", "q3")));
   }
   
   @Test
   public void findsMatchingEntries() {
      controller.addBooleanQuestion("alpha 1");
      controller.addBooleanQuestion("alpha 2");
      controller.addBooleanQuestion("beta 1");

      List<Question> questions = controller.findWithMatchingText("alpha");
      
      assertThat(
         questions.stream().map(Question::getText).collect(Collectors.toList()),
         equalTo(Arrays.asList("alpha 1", "alpha 2")));
   }
}

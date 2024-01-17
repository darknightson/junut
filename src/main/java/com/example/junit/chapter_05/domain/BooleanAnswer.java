/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package com.example.junit.chapter_05.domain;

class BooleanAnswer {
   private int questionId;
   private boolean value;

   BooleanAnswer(int questionId, boolean value) {
      this.questionId = questionId;
      this.value = value;
   }

   boolean getValue() {
      return value;
   }

   int getQuestionId() {
      return questionId;
   }
}

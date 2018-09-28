package com.brunorozendo.brewer.model.services.exception;

public class FieldValueExcepetion extends RuntimeException {

  public FieldValueExcepetion(String fieldName) {
    super("The field: " + fieldName + " has invalid value");
  }

}

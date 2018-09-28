package com.brunorozendo.brewer.model.services.exception;

public class DuplicateNameField extends RuntimeException {


  public DuplicateNameField(String fieldName) {
    super("Campo duplicado: " + fieldName);
  }

}
 
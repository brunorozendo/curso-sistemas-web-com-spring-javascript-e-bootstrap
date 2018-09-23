package com.brunorozendo.brewer.services.exception;

public class DuplicateNameField extends RuntimeException {


  public DuplicateNameField(String fieldName) {
    super("Campo duplicado: " + fieldName);
  }

}
 
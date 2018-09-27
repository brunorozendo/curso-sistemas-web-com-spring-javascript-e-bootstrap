package com.brunorozendo.brewer.controllers.handler.exception;

import com.brunorozendo.brewer.services.exception.DuplicateNameField;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {

  @ExceptionHandler(DuplicateNameField.class)
  public ResponseEntity<Object> ex1(DuplicateNameField e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }

}

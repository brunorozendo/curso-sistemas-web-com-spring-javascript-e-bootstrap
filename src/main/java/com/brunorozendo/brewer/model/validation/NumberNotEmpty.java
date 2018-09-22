package com.brunorozendo.brewer.model.validation;

import com.brunorozendo.brewer.model.validation.impl.NumberNotEmptyImpl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberNotEmptyImpl.class)
public @interface NumberNotEmpty {

  /**
   * Mensagem de validação para NumberNotEmptty.
   * key em properttiles <code>com.brunorozendo.brewer.validation.NumberNotEmptty.message</code>.
   * @return String
   */
  String message() default "{com.brunorozendo.brewer.validation.NumberNotEmptty.message}";

  /***
   * TO DO.
   * @return Class<?>[]
   */
  Class<?>[] groups() default {};

  /***
   * TO DO.
   * @return Class<? extends Payload>[]
   */
  Class<? extends Payload>[] payload() default {};

}



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
@SuppressWarnings("unused")
public @interface NumberNotEmpty {

  /**
   * Mensagem de valida&ccedil;&atilde;o para NumberNotEmpty.
   * key em properttiles <code>com.brunorozendo.brewer.validation.NumberNotEmpty.message</code>.
   * @return String
   */
  String message() default "{com.brunorozendo.brewer.validation.NumberNotEmpty.message}";

  /***
   * &#x54;ODO.
   * @return Class &lt;?&gt;[]
   */
  Class<?>[] groups() default {};

  /***
   * &#x54;ODO.
   * @return Class &lt;? extends Payload&gt;[]
   */
  Class<? extends Payload>[] payload() default {};

}



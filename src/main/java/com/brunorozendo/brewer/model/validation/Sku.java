package com.brunorozendo.brewer.model.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?")
@SuppressWarnings("unused")
public @interface Sku {

  /**
   * Mensagem de validacao.
   *
   * @return String
   */
  @OverridesAttribute(constraint = Pattern.class, name = "message")
  String message() default "Shuld be fallow the pattern XX9999";

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

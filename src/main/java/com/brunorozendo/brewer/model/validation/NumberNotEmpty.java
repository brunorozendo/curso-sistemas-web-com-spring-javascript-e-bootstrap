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


    String message() default "{com.brunorozendo.brewer.validation.NumberNotEmptty.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}



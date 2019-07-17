package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Sabor;
import com.google.common.base.Enums;
import java.util.function.Predicate;
import org.springframework.core.convert.converter.Converter;

public class SaborConverter implements Converter<String, Sabor> {

  @Override
  public Sabor convert(String source) {
    return getSabor(getStringPredicate(), source);
  }

  Predicate<String> getStringPredicate() {
    return s -> Enums.getIfPresent(Sabor.class, s).isPresent();
  }

  Sabor getSabor(Predicate<String> valid, String source) {
    if (valid.test(source)) {
      return Sabor.valueOf(source);
    }
    return null;
  }
}

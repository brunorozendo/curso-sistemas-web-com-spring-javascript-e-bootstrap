package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Sabor;
import java.util.function.Predicate;
import org.springframework.core.convert.converter.Converter;

public class SaborConverter implements Converter<String, Sabor> {

  @Override
  public Sabor convert(String source) {
    return getSabor(getStringPredicate(), source);
  }

  Predicate<String> getStringPredicate() {
    return s -> {
      for (Sabor c : Sabor.values()) {
        if (c.name().equals(s)) {
          return true;
        }
      }
      return false;
    };
  }

  Sabor getSabor(Predicate<String> valid, String source) {
    if (valid.test(source)) {
      return Sabor.valueOf(source);
    }
    return null;
  }
}

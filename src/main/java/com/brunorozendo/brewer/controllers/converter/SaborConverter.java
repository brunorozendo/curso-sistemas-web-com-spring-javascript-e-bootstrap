package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Sabor;
import java.util.function.Predicate;
import org.springframework.core.convert.converter.Converter;

public class SaborConverter implements Converter<String, Sabor> {

  @Override
  public Sabor convert(String source) {
    Predicate<String> valid = s -> !s.isEmpty();
    return getSabor(valid, source);
  }

  /***
   * Convertesr de string para Sabor
   * @param valid
   * @param source
   * @return Sabor
   */
  public Sabor getSabor(Predicate<String> valid, String source) {
    if (valid.test(source)) {
      return Sabor.valueOf(source);
    }
    return null;
  }
}

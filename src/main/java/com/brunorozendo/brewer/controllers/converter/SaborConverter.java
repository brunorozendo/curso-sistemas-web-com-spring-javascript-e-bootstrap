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
   * <p>Convertesr de string para Sabor.</p>
   * @param valid um Predicate&lt;String&gt;
   * @param source uma String que representa o um Sabor. Ex: "Forte"
   * @return Sabor
   */
  public Sabor getSabor(Predicate<String> valid, String source) {
    if (valid.test(source)) {
      return Sabor.valueOf(source);
    }
    return null;
  }
}

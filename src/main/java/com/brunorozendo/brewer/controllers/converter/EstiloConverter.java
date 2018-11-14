package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Estilo;
import java.util.function.Predicate;
import org.springframework.core.convert.converter.Converter;

public class EstiloConverter implements Converter<String, Estilo> {
  @Override
  public Estilo convert(String source) {
    return getEstilo(
        s -> !s.isEmpty(),
        source);
  }

  public Estilo getEstilo(Predicate<String> valid, String source) {
    if (valid.test(source)) {
      Estilo estilo = new Estilo();
      estilo.setId(Integer.valueOf(source));
      return estilo;
    }
    return null;
  }
}

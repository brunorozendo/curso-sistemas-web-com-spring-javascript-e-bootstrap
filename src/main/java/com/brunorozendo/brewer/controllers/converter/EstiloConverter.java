package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Estilo;
import java.util.function.Predicate;
import org.springframework.core.convert.converter.Converter;

public class EstiloConverter implements Converter<String, Estilo> {
  @Override
  public Estilo convert(String id) {
    return getEstilo(
        s -> !s.isEmpty(),
        id);
  }

  /***
   * Conversor de string em Estilo
   * @param valid
   * @param id
   * @return Estilo
   */
  public Estilo getEstilo(Predicate<String> valid, String id) {
    if (valid.test(id)) {
      Estilo estilo = new Estilo();
      estilo.setId(Integer.valueOf(id));
      return estilo;
    }
    return null;
  }
}

package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Estilo;
import org.springframework.core.convert.converter.Converter;

public class EstiloConverter implements Converter<String, Estilo> {
  @Override
  public Estilo convert(String source) {
    if (!source.isEmpty()) {
      Estilo estilo = new Estilo();
      estilo.setId(Integer.valueOf(source));
      return estilo;
    }
    return null;
  }
}

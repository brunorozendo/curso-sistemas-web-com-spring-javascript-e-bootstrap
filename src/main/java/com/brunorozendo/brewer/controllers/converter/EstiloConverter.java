package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Estilo;
import org.springframework.core.convert.converter.Converter;

public class EstiloConverter implements Converter<Integer, Estilo> {
  @Override
  public Estilo convert(Integer source) {
    Estilo estilo = new Estilo();
    estilo.setId(source);
    return estilo;
  }
}

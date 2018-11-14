package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Sabor;
import org.springframework.core.convert.converter.Converter;

/**
 *
 */
public class SaborConverter implements Converter<String, Sabor> {

  @Override
  public Sabor convert(String source) {
    if (!source.isEmpty()) {
      return Sabor.valueOf(source);
    }
    return null;
  }
}

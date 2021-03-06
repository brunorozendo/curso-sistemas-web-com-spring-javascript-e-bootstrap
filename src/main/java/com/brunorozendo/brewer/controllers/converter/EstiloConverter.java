package com.brunorozendo.brewer.controllers.converter;

import com.brunorozendo.brewer.model.entity.Estilo;
import java.util.function.Predicate;
import org.springframework.core.convert.converter.Converter;

public class EstiloConverter implements Converter<String, Estilo> {
  @Override
  public Estilo convert(String id) {
    return getEstilo(
        getStringPredicate(),
        id);
  }

  Predicate<String> getStringPredicate() {
    return s -> {
      try {
        String value = (s != null)  ? s.trim() : "";
        Integer.valueOf(value);
      } catch (NumberFormatException e) {
        return false;
      }
      return true;
    };
  }


  Estilo getEstilo(Predicate<String> valid, String id) {
    if (valid.test(id)) {
      Estilo estilo = new Estilo();
      estilo.setId(Integer.valueOf(id));
      return estilo;
    }
    return null;
  }
}

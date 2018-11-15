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

  private Predicate<String> getStringPredicate() {
    return s -> s != null && !s.trim().isEmpty();
  }

  /***
   * <p>Conversor de string em Estilo.</p>
   *
   * @param valid um Predicate&lt;String&gt;
   * @param id uma String que cont&eacute;m o valor do id Ex: "10"
   * @return Estilo
   */
  private Estilo getEstilo(Predicate<String> valid, String id) {
    if (valid.test(id)) {
      Estilo estilo = new Estilo();
      estilo.setId(Integer.valueOf(id));
      return estilo;
    }
    return null;
  }
}

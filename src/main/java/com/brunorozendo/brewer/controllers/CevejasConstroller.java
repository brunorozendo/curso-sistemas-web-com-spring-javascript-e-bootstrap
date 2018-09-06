package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.model.Cerveja;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CevejasConstroller {

  private final Logger logger = LoggerFactory.getLogger(JdbcDataSourceExample.class);

  enum Paginas {
    CADASTRO("cervejas/CadastroCerveja");
    String path;
    Paginas(String path) {
      this.path = path;
    }

    @Override
    public String toString() {
      return this.path;
    }
  }

  @GetMapping("cervejas/novo")
  public String novo() {
    return Paginas.CADASTRO.toString();
  }

  @PostMapping("cervejas/novo")
  public String cadastrar(Cerveja cerveja) {
    logger.info(cerveja.getSku());
    return Paginas.CADASTRO.toString();
  }

}

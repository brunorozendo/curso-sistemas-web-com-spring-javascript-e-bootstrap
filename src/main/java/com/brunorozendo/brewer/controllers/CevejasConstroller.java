package com.brunorozendo.brewer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CevejasConstroller {

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

}

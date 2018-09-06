package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.model.Cerveja;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CevejasConstroller {

  private final Logger logger = LoggerFactory.getLogger(JdbcDataSourceExample.class);

  private enum Paginas {
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

  /*** Cadastro de cerveja.
   * @param cerveja  vindo da tela
   * @param result resultato da valida&ccedil;&atilde;o do em cima do primeiro parametro (cerveja)
   * @return String a pagina atual
   */
  @PostMapping("cervejas/novo")
  public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model,
                          RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      result.getAllErrors().forEach(o -> logger.error(o.getDefaultMessage()));
      model.addAttribute("messagem", "com erro");
      return Paginas.CADASTRO.toString();
    }
    redirectAttributes.addFlashAttribute("messagem", "sucesso!");
    logger.info(cerveja.getSku());
    return "redirect:/cervejas/novo";
  }

}

package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.model.Cerveja;
import java.util.HashMap;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
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


  /**
   * Carrega a p&aacute;gina de cadastro e cerveja.
   *
   * @param  model
   *         objeto necess&aacute;rio para trafegar as mensagens/objetos para a tela
   *
   * @return  {@code String} url da pa&#x1f5;ina atual
   *
   * @since 3.4
   *
   * @see    Cerveja
   * @see    Model
   */
  @GetMapping("cervejas/novo")
  public ModelAndView novo(Model model) {
    model.addAttribute(new Cerveja());
    HashMap<String, Object> data = new HashMap<>();
    data.put("view", Paginas.CADASTRO.toString());

    return new ModelAndView("layout.html", data);

  }



  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar a cerveja.
   *
   * @param  cerveja
   *         objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado
   *
   * @param  result
   *         objeto que cont&eacute;m as informa&ccedil;&otilde;es do a valida&ccedil;&atilde;o
   *         do parametro cerveja
   *
   * @param  model
   *         objeto necess&aacute;rio para trafegar as mensagens/objetos para a tela
   *
   * @param  redirectAttributes
   *         objeto necess&aacute;rio trafegar as mensagem enjtre as telas
   *
   * @return  {@code String} url da pa&#x1f5;ina atual
   *
   * @since 3.4
   *
   * @see    Cerveja
   * @see    BindingResult
   * @see    Model
   * @see    RedirectAttributes
   */
  @PostMapping("cervejas/novo")
  public ModelAndView novo(@Valid Cerveja cerveja, BindingResult result, Model model,
                          RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      result.getAllErrors().forEach(o -> logger.error(o.getDefaultMessage()));


      HashMap<String, Object> data = new HashMap<>();
      data.put("view", Paginas.CADASTRO.toString());
      data.put("messagem", "com erro");

      return new ModelAndView("layout.html", data);

    }
    redirectAttributes.addFlashAttribute("messagem", "sucesso!");
    logger.info(cerveja.getSku());
    return new ModelAndView("redirect:/cervejas/novo");
  }

}

package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.controllers.util.UtilController;
import com.brunorozendo.brewer.model.Estilo;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/estilos")
public class EstiloController extends UtilController {

  /**
   * Carrega a p&aacute;gina de cadastro de estilo.
   *
   * @param estilo objeto que est&aacute; tela que ser&aacute; carregado na tela.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see Estilo
   * @since 5.14
   */
  @RequestMapping("/novo")
  public ModelAndView index(Estilo estilo) {
    return modelAndView("estilo/CadastroEstilo");
  }

  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar o cliente.
   * Vindo da tala.
   *
   * @param estilo             objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado.
   * @param result             objeto que cont&eacute;m as informa&ccedil;&otilde;es da
   *                           valida&ccedil;&atilde;o do parametro estilo.
   * @param redirectAttributes objeto necess&aacute;rio trafegar as mensagem enjtre as telas.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see Estilo
   * @see BindingResult
   * @since 5.14
   */
  @PostMapping("/novo")
  public ModelAndView salve(@Valid Estilo estilo, BindingResult result, RedirectAttributes
      redirectAttributes) {
    if (result.hasErrors()) {
      return index(estilo);
    }
    redirectAttributes.addFlashAttribute("message", "Salvo com sucesso");
    redirectAttributes.addFlashAttribute("messageType", MESSAGE_TYPE_SUCESS);
    return redirect("/estilos/novo");
  }

  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar o cliente.
   * Vindo de uma requisição ajax.
   *
   * @param estilo objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado.
   * @param result objeto que cont&eacute;m as informa&ccedil;&otilde;es da
   *               valida&ccedil;&atilde;o do parametro estilo.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see Estilo
   * @see BindingResult
   * @since 5.14
   */
  @PostMapping
  public @ResponseBody
  ResponseEntity<Object> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {
    if (result.hasErrors()) {
      return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
    }
    return ResponseEntity.ok(estilo);
  }

}

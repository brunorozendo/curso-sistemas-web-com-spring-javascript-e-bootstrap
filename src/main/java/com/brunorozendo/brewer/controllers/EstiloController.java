package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.controllers.dto.EstiloDto;
import com.brunorozendo.brewer.controllers.util.UtilController;
import com.brunorozendo.brewer.services.EstiloService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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


  @Autowired
  EstiloService estiloService;
  /**
   * Carrega a p&aacute;gina de cadastro de estiloDto.
   *
   * @param estiloDto objeto que est&aacute; tela que ser&aacute; carregado na tela.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see EstiloDto
   * @since 5.14
   */
  @RequestMapping("/novo")
  public ModelAndView index(EstiloDto estiloDto) {
    return modelAndView("estilo/CadastroEstilo");
  }

  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar o cliente.
   * Vindo da tala.
   *
   * @param estiloDto             objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado.
   * @param result             objeto que cont&eacute;m as informa&ccedil;&otilde;es da
   *                           valida&ccedil;&atilde;o do parametro estiloDto.
   * @param redirectAttributes objeto necess&aacute;rio trafegar as mensagem enjtre as telas.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see EstiloDto
   * @see BindingResult
   * @since 5.14
   */
  @PostMapping("/novo")
  public ModelAndView salve(@Valid EstiloDto estiloDto, BindingResult result, RedirectAttributes
      redirectAttributes) {
    if (result.hasErrors()) {
      return index(estiloDto);
    }
    estiloService.salvar(estiloDto);
    redirectAttributes.addFlashAttribute("message", "Salvo com sucesso");
    redirectAttributes.addFlashAttribute("messageType", MESSAGE_TYPE_SUCESS);
    return redirect("/estilos/novo");
  }

  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar o cliente.
   * Vindo de uma requisição ajax.
   *
   * @param estiloDto objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado.
   * @param result objeto que cont&eacute;m as informa&ccedil;&otilde;es da
   *               valida&ccedil;&atilde;o do parametro estiloDto.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see EstiloDto
   * @see BindingResult
   * @since 5.14
   */
  @PostMapping
  public @ResponseBody
  ResponseEntity<Object> salvar(@RequestBody @Valid EstiloDto estiloDto, BindingResult result) {
    if (result.hasErrors()) {
      return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
    }
    return ResponseEntity.ok(estiloDto);
  }

}

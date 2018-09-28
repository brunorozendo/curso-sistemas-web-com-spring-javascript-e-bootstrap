package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.controllers.dto.EstiloDto;
import com.brunorozendo.brewer.controllers.util.UtilController;
import com.brunorozendo.brewer.model.services.EstiloService;
import com.brunorozendo.brewer.model.services.exception.DuplicateNameField;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

  private EstiloService estiloService;

  public EstiloController(EstiloService estiloService) {
    this.estiloService = estiloService;
  }

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
   * @param estiloDto          objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado.
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
    try {
      estiloService.salvar(estiloDto);
    } catch (DuplicateNameField e) {
      result.rejectValue("nome", e.getMessage(), e.getMessage());
      return index(estiloDto);
    }

    redirectAttributes.addFlashAttribute("message", "Salvo com sucesso");
    redirectAttributes.addFlashAttribute("messageType", MESSAGE_TYPE_SUCESS);
    return redirect("/estilos/novo");
  }

  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar o cliente.
   * Vindo de uma requisição ajax.
   *
   * @param estiloDto objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado.
   * @param result    objeto que cont&eacute;m as informa&ccedil;&otilde;es da
   *                  valida&ccedil;&atilde;o do parametro estiloDto.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see EstiloDto
   * @see BindingResult
   * @since 5.14
   */
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
  public @ResponseBody
  ResponseEntity<Object> salvar(@RequestBody @Valid EstiloDto estiloDto,
                                BindingResult result) {
    if (result.hasErrors()) {
      FieldError fieldErro = result.getFieldError("nome");
      String message = Objects.requireNonNull(fieldErro).getDefaultMessage();
      return ResponseEntity.badRequest().body(message);
    }
    return ResponseEntity.ok(estiloService.salvar(estiloDto));
  }

}

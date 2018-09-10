package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.controllers.util.UtilController;
import com.brunorozendo.brewer.model.Cidade;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/cidades")
public class CidadeController extends UtilController {


  private static final String VIEW_FORM_CADASTRO = "/cidade/CadastroCidade";
  private static final String URL_FORM_CADASTRO = "/cidades/novo";

  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar a cidade.
   *
   * @param cidade carrega uma instância do objecto na tela
   * @return {@code ModelAndView}  pa&#x1f5;ina atual
   * @see Cidade
   * @see BindingResult
   * @see RedirectAttributes
   * @since 5.13
   */
  @GetMapping("/novo")
  public ModelAndView index(Cidade cidade) {
    return modelAndView(VIEW_FORM_CADASTRO);
  }



  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar a cidade.
   *
   * @param cidade            objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado
   * @param result             objeto que cont&eacute;m as informa&ccedil;&otilde;es do a
   *                           valida&ccedil;&atilde;o do parametro cerveja
   * @param redirectAttributes objeto necess&aacute;rio trafegar as mensagem enjtre as telas
   * @return {@code ModelAndView} url da pa&#x1f5;ina atual
   * @see Cidade
   * @see BindingResult
   * @see RedirectAttributes
   * @since 3.4
   */
  @PostMapping("/novo")
  public ModelAndView salve(@Valid Cidade cidade, BindingResult result, RedirectAttributes
      redirectAttributes) {
    if (result.hasErrors()) {
      return index(cidade);
    }
    redirectAttributes.addFlashAttribute("msg", "com sucesso");
    return redirect(URL_FORM_CADASTRO);
  }


}

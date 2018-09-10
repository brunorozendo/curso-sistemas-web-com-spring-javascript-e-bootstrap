package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.controllers.util.UtilController;
import com.brunorozendo.brewer.model.Usuario;
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
@RequestMapping("/usuarios")
public class UsuarioController extends UtilController {

  private static final String VIEW_FORM_CADASTRO = "/usuario/CadastroUsuario";
  private static final String URL_FORM_CADASTRO = "/usuarios/novo";


  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar a cerveja.
   *
   * @param usuario carrega uma instanacia nova na tela
   * @return {@code ModelAndView}  pa&#x1f5;ina atual
   * @see Usuario
   * @since 5.11
   */
  @GetMapping("/novo")
  public ModelAndView index(Usuario usuario) {
    return modelAndView(VIEW_FORM_CADASTRO);
  }




  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar a cerveja.
   *
   * @param usuario            objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado
   * @param result             objeto que cont&eacute;m as informa&ccedil;&otilde;es do a
   *                           valida&ccedil;&atilde;o do parametro usuario
   * @param redirectAttributes objeto necess&aacute;rio trafegar as mensagem enjtre as telas
   * @return {@code ModelAndView}  pa&#x1f5;ina atual
   * @see Usuario
   * @see BindingResult
   * @see RedirectAttributes
   * @since 5.11
   */
  @SuppressWarnings("unused")
  @PostMapping("/novo")
  public ModelAndView salve(@Valid Usuario usuario, BindingResult result, RedirectAttributes
      redirectAttributes) {
    if (result.hasErrors()) {
      return index(usuario);
    }
    redirectAttributes.addFlashAttribute("msg", "com sucesso");
    return redirect(URL_FORM_CADASTRO);
  }


}

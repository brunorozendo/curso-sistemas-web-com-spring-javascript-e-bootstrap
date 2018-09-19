package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.controllers.util.UtilController;
import com.brunorozendo.brewer.model.entity.Cliente;
import com.brunorozendo.brewer.model.entity.Estado;
import com.brunorozendo.brewer.model.entity.TipoPessoa;
import java.util.ArrayList;
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
@RequestMapping("/clientes")
public class ClienteController extends UtilController {

  private static final String VIEW_FORM_CADASTRO = "/ccliente/CadastroCliente";
  private static final String URL_FORM_CADASTRO = "/clientes/novo";

  /**
   * Carrega a p&aacute;gina de cadastro do cliente.
   *
   * @param cliente objeto que est&aacute; tela que ser&aacute; carregado na tela.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see Cliente
   * @see BindingResult
   * @see RedirectAttributes
   * @since 5.10
   */
  @GetMapping("/novo")
  public ModelAndView index(Cliente cliente) {
    addModel("tipoPessoa", TipoPessoa.values());
    addModel("estados", new ArrayList<Estado>());
    return modelAndView(VIEW_FORM_CADASTRO);
  }


  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar o cliente.
   *
   * @param cliente            objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado.
   * @param result             objeto que cont&eacute;m as informa&ccedil;&otilde;es da
   *                           valida&ccedil;&atilde;o do parametro cerveja.
   * @param redirectAttributes objeto necess&aacute;rio trafegar as mensagem enjtre as telas.
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see Cliente
   * @see BindingResult
   * @see RedirectAttributes
   * @since 5.10
   */
  @PostMapping("/novo")
  public ModelAndView salve(@Valid Cliente cliente, BindingResult result,
                            RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      return index(cliente);
    }
    redirectAttributes.addFlashAttribute("msg", "com sucesso");
    return redirect(URL_FORM_CADASTRO);
  }


}

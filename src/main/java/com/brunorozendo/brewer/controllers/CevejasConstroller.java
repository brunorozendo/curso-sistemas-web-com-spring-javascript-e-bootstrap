package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.controllers.dto.CervejaDto;
import com.brunorozendo.brewer.controllers.util.UtilController;
import com.brunorozendo.brewer.model.entity.Estilo;
import com.brunorozendo.brewer.model.entity.Origem;
import com.brunorozendo.brewer.model.entity.Sabor;
import com.brunorozendo.brewer.model.repositories.CervejaRepository;
import com.brunorozendo.brewer.model.repositories.EstiloRepository;
import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SuppressWarnings("unused")
@Controller
public class CevejasConstroller extends UtilController {

  private final Logger logger = LoggerFactory.getLogger(CevejasConstroller.class);

  private static final String VIEW_FORM_CADASTRO = "cervejas/CadastroCerveja";
  private static final String URL_FORM_CADASTRO = "/cervejas/novo";

  @Autowired
  CervejaRepository cervejaRepository;

  @Autowired
  EstiloRepository estiloRepository;


  /**
   * Carrega a p&aacute;gina de cadastro de cervejaDto.
   *
   * @param cervejaDto ocarrega uma instância do objecto na tela
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see CervejaDto
   * @since 3.4
   */
  @GetMapping(URL_FORM_CADASTRO)
  public ModelAndView novo(CervejaDto cervejaDto) {
    cervejaRepository.findAll();

    return modelAndView(VIEW_FORM_CADASTRO);
  }

  @ModelAttribute(name = "estilos")
  private List<Estilo> getEstilos() {
    return estiloRepository.findAll();
  }

  @ModelAttribute(name = "sabores")
  private Sabor[] getSabores() {
    return Sabor.values();
  }

  @ModelAttribute(name = "origens")
  private Origem[] getOrigens() {
    return Origem.values();
  }


  /**
   * Recebe  a requisi&ccedil;&atilde;o para salvar/atualizar a cervejaDto.
   *
   * @param cervejaDto            objeto que est&aacute; tela que ser&aacute; cadastrado/atualizado
   * @param result             objeto que cont&eacute;m as informa&ccedil;&otilde;es do a
   *                           valida&ccedil;&atilde;o do parametro cervejaDto
   * @param model              objeto necess&aacute;rio para trafegar as mensagens/objetos para a
   *                           tela
   * @param redirectAttributes objeto necess&aacute;rio trafegar as mensagem enjtre as telas
   * @return {@code String} url da pa&#x1f5;ina atual
   * @see CervejaDto
   * @see BindingResult
   * @see Model
   * @see RedirectAttributes
   * @since 3.4
   */
  @PostMapping(URL_FORM_CADASTRO)
  public ModelAndView novo(@Valid CervejaDto cervejaDto, BindingResult result, Model model,
                           RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      result.getAllErrors().forEach(o -> logger.error(o.getDefaultMessage()));


      HashMap<String, Object> data = new HashMap<>();
      data.put("view", VIEW_FORM_CADASTRO);
      data.put("messagem", "com erro");

      return new ModelAndView("layout.html", data);

    }
    redirectAttributes.addFlashAttribute("messagem", "sucesso!");
    logger.info(cervejaDto.getSku());
    return redirect(URL_FORM_CADASTRO);
  }

}

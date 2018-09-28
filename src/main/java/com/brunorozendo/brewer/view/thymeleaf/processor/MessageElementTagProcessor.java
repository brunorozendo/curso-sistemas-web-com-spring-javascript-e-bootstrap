package com.brunorozendo.brewer.view.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.model.IStandaloneElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class MessageElementTagProcessor extends AbstractElementTagProcessor {

  private static final String TAG_NAME = "messages";
  private static final int PRECEDENCE = 1000;

  /**
   * Create processador no html.
   */
  public MessageElementTagProcessor(String dialectPrefix) {
    super(
        TemplateMode.HTML,
        dialectPrefix,
        TAG_NAME,
        true,
        null,
        false,
        PRECEDENCE
    );
  }

  @Override
  protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
                           IElementTagStructureHandler structureHandler) {
    IModelFactory factory = context.getModelFactory();
    IModel model = factory.createModel();
    IStandaloneElementTag frag = factory.createStandaloneElementTag("th:block", "th:replace",
        "~{fragments/alerts :: message}");
    model.add(frag);
    structureHandler.replaceWith(model, true);

  }
}

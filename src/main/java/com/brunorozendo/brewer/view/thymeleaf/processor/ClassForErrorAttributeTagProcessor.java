package com.brunorozendo.brewer.view.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring5.util.FieldUtils;
import org.thymeleaf.templatemode.TemplateMode;


public class ClassForErrorAttributeTagProcessor extends AbstractAttributeTagProcessor {

  private static final String ATTR_NAME = "classforerror";
  private static final int ATTR_PRIORITY = 1000;

  public ClassForErrorAttributeTagProcessor(String dialectPrefix) {
    super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, ATTR_PRIORITY, true);

  }

  @Override
  protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
                           AttributeName attributeName, String attributeValue,
                           IElementTagStructureHandler structureHandler) {

    boolean fieldHasErros = FieldUtils.hasErrors(context, attributeValue);

    if (fieldHasErros) {
      String currentClassesCss = tag.getAttributeValue("class");
      structureHandler.setAttribute("class", currentClassesCss + " has-error");
    }
  }
}

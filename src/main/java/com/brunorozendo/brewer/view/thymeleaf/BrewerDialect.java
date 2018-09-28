package com.brunorozendo.brewer.view.thymeleaf;

import com.brunorozendo.brewer.view.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.brunorozendo.brewer.view.thymeleaf.processor.MessageElementTagProcessor;
import java.util.HashSet;
import java.util.Set;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

public class BrewerDialect extends AbstractProcessorDialect {

  public BrewerDialect() {
    super("Algaworks brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
  }

  @Override
  public Set<IProcessor> getProcessors(String dialectPrefix) {
    Set<IProcessor> processors = new HashSet<>();

    processors.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
    processors.add(new MessageElementTagProcessor(dialectPrefix));

    return processors;
  }
}

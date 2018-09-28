package org.spring.config;

import com.brunorozendo.brewer.controllers.DataSourceController;
import com.brunorozendo.brewer.controllers.converter.EstiloConverter;
import com.brunorozendo.brewer.controllers.converter.SaborConverter;
import com.brunorozendo.brewer.view.thymeleaf.BrewerDialect;
import java.math.BigDecimal;
import java.util.Locale;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan(basePackageClasses = DataSourceController.class)
@EnableWebMvc
public class ConfigWeb extends WebMvcConfigurerAdapter implements ApplicationContextAware {

  private ApplicationContext applicationCcontext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationCcontext = applicationContext;
  }

  private ITemplateResolver templateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setApplicationContext(this.applicationCcontext);
    resolver.setPrefix("classpath:/");
    resolver.setSuffix(".html");
    resolver.setCheckExistence(true);
    resolver.setTemplateMode(TemplateMode.HTML);
    return resolver;
  }

  private ISpringTemplateEngine templateEngine() {
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setEnableSpringELCompiler(true);
    engine.setTemplateResolver(templateResolver());
    engine.addDialect(new BrewerDialect());
    return engine;
  }


  /**
   * Bean responsável por passar o thymeleaf como view.
   *
   * @return ViewResolver
   */
  @Bean
  public ViewResolver viewResolver() {
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setTemplateEngine(templateEngine());
    resolver.setCharacterEncoding("UTF-8");
    return resolver;

  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/assets/**")
        .addResourceLocations("/assets/");
  }

  /**
   * Adiciona os converters que o spring conhece.
   *
   * @return FormattingConversionService
   * @see  EstiloConverter
   * @see  SaborConverter
   */
  @Bean
  public FormattingConversionService mvcConversionService() {
    FormattingConversionService service = new FormattingConversionService();
    service.addConverter(new EstiloConverter());
    service.addConverter(new SaborConverter());


    NumberStyleFormatter bigDecilaFormatter = new NumberStyleFormatter("#,##0.00");
    service.addFormatterForFieldType(BigDecimal.class, bigDecilaFormatter);

    NumberStyleFormatter integerFormatter = new NumberStyleFormatter("#,##0");
    service.addFormatterForFieldType(Integer.class, integerFormatter);

    service.addFormatterForFieldType(Number.class, bigDecilaFormatter);

    return service;
  }


  /**
   * Define que a linguagem ser&aacute; pt-BR.
   * @return LocaleResolver
   */
  @Bean
  public LocaleResolver localeResolver() {
    return  new FixedLocaleResolver(new Locale("pt", "BR"));
  }


}

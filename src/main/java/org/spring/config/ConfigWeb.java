package org.spring.config;

import com.brunorozendo.brewer.controllers.DataSourceController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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
    return engine;
  }


  /**
   * Bean responsável por passar o thymeleaf como view.
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



}

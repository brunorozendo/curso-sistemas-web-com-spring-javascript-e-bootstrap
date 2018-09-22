package org.spring.config;

import com.brunorozendo.brewer.services.CervejaService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CervejaService.class)
public class ConfigService {
}

package org.spring.config;

import com.brunorozendo.brewer.model.entity.Cerveja;
import com.brunorozendo.brewer.model.repositories.CervejaRepository;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackageClasses = CervejaRepository.class)
public class ConfigJpa {

  /**
   * cria um datasrouce baseado no jndi "jdbc/brewer".
   */
  @Bean
  public ComboPooledDataSource dataSource() {
    JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
    dataSourceLookup.setResourceRef(true);
    return (ComboPooledDataSource) dataSourceLookup.getDataSource("jdbc/brewer");
  }

  /**
   * A
   * necessário para o spring data jpa nãoo gerar o erro
   * <code>No bean named 'transactionManager' is defined</code>.
   */
  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }

  /**
   * methodo que especifica qual o vendero (eclipselink, hibernate...) será usando.
   */
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
    adapter.setDatabase(Database.H2);
    adapter.setShowSql(false);
    adapter.setGenerateDdl(false);
    return adapter;
  }

  /**
   * Cria EntityManagerFactory, o qual será usado para recuarper um EntityManager.
   */
  @Bean
  public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter
      jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setDataSource(dataSource);
    factory.setJpaVendorAdapter(jpaVendorAdapter);
    factory.getJpaPropertyMap().put("eclipselink.weaving", "false");
    factory.setPackagesToScan(Cerveja.class.getPackage().getName());
    factory.afterPropertiesSet();
    return factory.getObject();
  }


}

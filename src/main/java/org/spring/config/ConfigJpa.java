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
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackageClasses = CervejaRepository.class,
    enableDefaultTransactions = false)
@EnableTransactionManagement
public class ConfigJpa {

  /**
   * cria um datasource baseado no jndi "jdbc/brewer".
   * @return ComboPooledDataSource from c3p0
   */
  @Bean
  public ComboPooledDataSource dataSource() {
    JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
    dataSourceLookup.setResourceRef(true);
    return (ComboPooledDataSource) dataSourceLookup.getDataSource("jdbc/brewer");
  }


  /**
   * A
   * necess&aacute;rio para o spring data jpa n&atilde;oo gerar o erro
   * <code>No bean named 'transactionManager' is defined</code>.
   * @param entityManagerFactory
   *        vindo do m&eacute;&#x74;odo {@link ConfigJpa#entityManagerFactory entityManagerFactory }
   * @return PlatformTransactionManager
   */
  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }

  /**
   * m&eacute;&#x74;odo que especifica qual o vendor (eclipselink, hibernate...) ser&aacute; usando.
   * @return JpaVendorAdapter
   * @see  Database POSTGRESQL
   */
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
    adapter.setDatabase(Database.POSTGRESQL);
    adapter.setShowSql(false);
    adapter.setGenerateDdl(false);
    return adapter;
  }

  /**
   * Cria EntityManagerFactory, o qual ser&aacute; usado para recuperar um EntityManager.
   * @param dataSource {@link ConfigJpa#dataSource dataSource }
   * @param jpaVendorAdapter {@link ConfigJpa#jpaVendorAdapter jpaVendorAdapter }
   * @return EntityManagerFactory
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

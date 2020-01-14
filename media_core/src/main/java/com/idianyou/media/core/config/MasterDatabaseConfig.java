package com.idianyou.media.core.config;

import com.idianyou.media.core.entity.MasterTenant;
import com.idianyou.media.core.repository.MasteTenantRepository;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.idianyou.media.core.entity", "com.idianyou.media.core.repository"}, entityManagerFactoryRef = "masterEntityManagerFactory",
        transactionManagerRef = "masterTransactionManager")
@Slf4j
public class MasterDatabaseConfig {

    @Autowired
    private MasterDatabaseProperties masterDatabaseProperties;

    @Bean(name = "masterDatasource")
    public DataSource masterDatasource() {
        log.info("setting up masterDatasource with : {}", masterDatabaseProperties.toString());
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(masterDatabaseProperties.getUsername());
        dataSource.setPassword(masterDatabaseProperties.getPassword());
        dataSource.setJdbcUrl(masterDatabaseProperties.getUrl());
        dataSource.setDataSourceClassName(masterDatabaseProperties.getDriverClassName());
        dataSource.setPoolName(masterDatabaseProperties.getPoolName());
        dataSource.setMaximumPoolSize(masterDatabaseProperties.getMaxPoolSize());
        dataSource.setMinimumIdle(masterDatabaseProperties.getMinIdle());
        dataSource.setConnectionTimeout(masterDatabaseProperties.getConnectionTimeout());
        dataSource.setIdleTimeout(masterDatabaseProperties.getIdleTimeout());
        log.info("setup of masterDatasource successfully");
        return dataSource;
    }

    @Primary
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lb = new LocalContainerEntityManagerFactoryBean();
        lb.setDataSource(masterDatasource());
        lb.setPackagesToScan(new String[]{MasterTenant.class.getPackage().getName(), MasteTenantRepository.class.getPackage().getName()});
        lb.setPersistenceUnitName("master-database-persistence-unit");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lb.setJpaVendorAdapter(vendorAdapter);
        lb.setJpaProperties(hibernateProperties());
        log.info("setup of masterEntityManagerFactory successfully");
        return lb;
    }

    @Bean(name = "masterTransactionManager")
    public JpaTransactionManager masterTransactionManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        log.info("setup of masterTransactionManager successfully");
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.FORMAT_SQL, true);
        properties.put(Environment.HBM2DDL_AUTO, "update");
        return properties;
    }
}

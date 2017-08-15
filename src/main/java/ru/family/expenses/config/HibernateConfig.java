package ru.family.expenses.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:connectionDatabase.properties"})
public class HibernateConfig {

    private final Environment connectionDatabase;

    @Autowired
    public HibernateConfig(Environment connectionDatabase) {
        this.connectionDatabase = connectionDatabase;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
        entityManagerFactory.setPackagesToScan("ru.family.expenses");
        entityManagerFactory.setJpaPropertyMap(hibernateJpaProperties());
        entityManagerFactory.setJpaProperties(jpaProperties());
        return entityManagerFactory;
    }

    @Bean
    public Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.put("characterSetResults", "UTF-8");
        jpaProperties.put("useUnicode", true);
        jpaProperties.put("characterEncoding", "utf8");
        return jpaProperties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(connectionDatabase.getRequiredProperty("driver.class.name"));
        dataSource.setUrl(connectionDatabase.getRequiredProperty("database.url"));
        dataSource.setUsername(connectionDatabase.getRequiredProperty("database.username"));
        dataSource.setPassword(connectionDatabase.getRequiredProperty("database.password"));
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
    }

    private Map<String, ?> hibernateJpaProperties() {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", connectionDatabase.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.format_sql", connectionDatabase.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.show_sql", connectionDatabase.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }
}

package vn.kihon.utility.order;


import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "orderEntityManagerFactory",
        transactionManagerRef = "orderTransactionManager")
class OrderConfig {
    @Bean
    @ConfigurationProperties("order.datasource")
    DataSourceProperties orderDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    DataSource orderDataSource() {
        return orderDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    LocalContainerEntityManagerFactoryBean orderEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean instance = new LocalContainerEntityManagerFactoryBean();
        instance.setDataSource((orderDataSource()));
        instance.setJpaPropertyMap(Map.of("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"));
        instance.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        instance.setPackagesToScan(getClass().getPackageName());

        return instance;
    }

    @Bean
    PlatformTransactionManager orderTransactionManager() {
        return new JpaTransactionManager(Objects.requireNonNull(orderEntityManagerFactory().getObject()));
    }
}

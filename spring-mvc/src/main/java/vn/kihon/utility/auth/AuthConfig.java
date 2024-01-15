package vn.kihon.utility.auth;


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
@EnableJpaRepositories(entityManagerFactoryRef = "authEntityManagerFactory",
        transactionManagerRef = "authTransactionManager")
class AuthConfig {
    @Bean
    @ConfigurationProperties("auth.datasource")
    DataSourceProperties authDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    DataSource authDataSource() {
        return authDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    LocalContainerEntityManagerFactoryBean authEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean instance = new LocalContainerEntityManagerFactoryBean();
        instance.setDataSource((authDataSource()));
        instance.setJpaPropertyMap(Map.of("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"));
        instance.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        instance.setPackagesToScan(getClass().getPackageName());

        return instance;
    }

    @Bean
    PlatformTransactionManager authTransactionManager() {
        return new JpaTransactionManager(Objects.requireNonNull(authEntityManagerFactory().getObject()));
    }
}

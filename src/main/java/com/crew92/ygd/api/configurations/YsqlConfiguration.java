package com.crew92.ygd.api.configurations;

import com.crew92.ygd.api.repositories.SmokingAreaRepository;
import com.yugabyte.data.jdbc.datasource.YugabyteTransactionManager;
import com.yugabyte.data.jdbc.repository.config.AbstractYugabyteJdbcConfiguration;
import com.yugabyte.data.jdbc.repository.config.EnableYsqlRepositories;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableYsqlRepositories(basePackageClasses = {SmokingAreaRepository.class})
public class YsqlConfiguration extends AbstractYugabyteJdbcConfiguration {

    @Bean
    DataSource dataSource(@Value("${yugabyte.datasource.url}") String jdbcUrl,
                          @Value("${yugabyte.datasource.driver-class-name:org.postgresql.Driver}") String driverClassName,
                          @Value("${yugabyte.datasource.load-balance:false}") String loadBalance,
                          @Value("${yugabyte.datasource.username}") String username,
                          @Value("${yugabyte.datasource.password}") String password) {
        HikariConfig hikariConfig = new HikariConfig();
        if (driverClassName != null) {
            hikariConfig.setDriverClassName(driverClassName);
        }
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.addDataSourceProperty("load-balance", loadBalance);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    TransactionManager transactionManager(DataSource dataSource) {
        return new YugabyteTransactionManager(dataSource);
    }
}

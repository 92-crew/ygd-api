package com.crew92.ygd.api.configurations;

import com.yugabyte.data.jdbc.datasource.YugabyteTransactionManager;
import com.yugabyte.data.jdbc.repository.config.AbstractYugabyteJdbcConfiguration;
import com.yugabyte.data.jdbc.repository.config.EnableYsqlRepositories;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableYsqlRepositories
public class YsqlConfiguration extends AbstractYugabyteJdbcConfiguration {

    @Value("${datasource.host}")
    private String serverName;

    @Value("${datasource.port}")
    private String portNumber;

    @Value("${datasource.database}")
    private String databaseName;

    @Bean
    DataSource dataSource() {
        Properties poolProperties = new Properties();
        poolProperties.setProperty("dataSourceClassName", "com.yugabyte.ysql.YBClusterAwareDataSource");
        poolProperties.setProperty("dataSource.serverName", serverName);
        poolProperties.setProperty("dataSource.portNumber", portNumber);
        poolProperties.setProperty("dataSource.user", "admin");
        poolProperties.setProperty("dataSource.password", "00iVOBFpzEjARTBtZSrea0cNNf2lhk");
        poolProperties.setProperty("dataSource.databaseName", databaseName);
        HikariConfig hikariConfig = new HikariConfig(poolProperties);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
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

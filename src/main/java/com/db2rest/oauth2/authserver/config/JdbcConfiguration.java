package com.db2rest.oauth2.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

    private final DataBaseProperties dataBaseProperties;

    public JdbcConfiguration(DataBaseProperties dataBaseProperties) {
        this.dataBaseProperties = dataBaseProperties;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        var connectionDetail = dataBaseProperties.getConnectionDetail();
        final HikariConfig config = new HikariConfig();

        config.setJdbcUrl(connectionDetail.getUrl());
        config.setUsername(connectionDetail.getUserName());
        config.setPassword(connectionDetail.getPassword());
        config.setDriverClassName(connectionDetail.getDriverClassName());

        config.setAutoCommit(false);
        return new HikariDataSource(config);
    }
}

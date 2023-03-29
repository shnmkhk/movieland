package com.rabbit.mdb.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Profile({ "dev", "default" })
@PropertySource("application.properties")
public class BaseDAOImpl {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	private HikariDataSource hikariDataSource;

	public DataSource dataSource() {
		if (hikariDataSource == null) {
			HikariConfig config = new HikariConfig();
			// Configure which instance and what database user to connect with.
			config.setDriverClassName(driverClassName);
			config.setJdbcUrl(url);
			config.setUsername(username);
			config.setPassword(password);

			hikariDataSource = new HikariDataSource(config);
		}
		return hikariDataSource;
	}
}

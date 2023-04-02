package com.rabbit.mdb.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
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
			config.addDataSourceProperty("cachePrepStmts", "true");
			config.addDataSourceProperty("prepStmtCacheSize", "250");
			config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");			

			hikariDataSource = new HikariDataSource(config);
			
			hikariDataSource.setIdleTimeout(60000);
			hikariDataSource.setConnectionTimeout(60000);
			hikariDataSource.setValidationTimeout(3000);
			hikariDataSource.setMaxLifetime(60000);
			hikariDataSource.setMaximumPoolSize(20);
			hikariDataSource.setLeakDetectionThreshold(5000);
			hikariDataSource.setMinimumIdle(1);
		}
		return hikariDataSource;
	}
}

package com.fis.origenate.batchsftp.config;

import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.fis.origenate.batchsftp.service.impl.CommandLineParamsServiceImpl;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan({ "com.fis.origenate.batchsftp.config", "com.fis.origenate.batchsftp.step",
		"com.fis.origenate.batchsftp.service.impl", "com.fis.origenate.batchsftp" })
public class DataSourceConfiguration {

	@Autowired
	CommandLineParamsServiceImpl commandlineparamsserviceimpl;

	static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

	@Bean(name = "datasource1")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource masterDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(commandlineparamsserviceimpl.getDataSourceDriver1());
		dataSource.setUrl(commandlineparamsserviceimpl.getDataSourceUrl1());
		dataSource.setUsername(commandlineparamsserviceimpl.getDataSourceUsername1());
		dataSource.setPassword(commandlineparamsserviceimpl.getDataSourcePass1());
		return dataSource;

	}

	@Bean(name = "datasource2")
	@ConfigurationProperties(prefix = "spring.second-datasource")
	public DataSource secondDataSource() {

		/*
		 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 * dataSource.setDriverClassName(commandlineparamsserviceimpl.
		 * getDataSourceDriver2());
		 * dataSource.setUrl(commandlineparamsserviceimpl.getDataSourceUrl2());
		 * dataSource.setUsername(commandlineparamsserviceimpl.getDataSourceUsername2())
		 * ; dataSource.setPassword(commandlineparamsserviceimpl.getDataSourcePass2());
		 */

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.20.122.65:1521:orcl");
		dataSource.setUsername("prodqsc");
		dataSource.setPassword("prodqsc");
		return dataSource;

	}

	@Bean(name = "jdbc1")
	@Autowired
	public JdbcTemplate masterJdbcTemplate(@Qualifier("datasource1") DataSource dsMaster) {
		return new JdbcTemplate(dsMaster);
	}

	@Bean(name = "jdbc2")
	@Autowired
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("datasource2") DataSource dsMaster) {
		return new JdbcTemplate(dsMaster);
	}

}

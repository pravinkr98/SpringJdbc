package com.ps.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.ps.dao")
public class PersistenceConfig {
	
	@Bean
	public DataSource createHKDS() {
		HikariDataSource ds=null;
		//get dataSource object
		ds=new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setMaximumPoolSize(10);
		//return dataSource
		return ds;
	}
	
	@Bean
	public JdbcTemplate createJT() {
		JdbcTemplate jt=null;
		//create jdbc template object
		jt=new JdbcTemplate(createHKDS());
		//return jdbcTemplate
		return jt;
	}

}

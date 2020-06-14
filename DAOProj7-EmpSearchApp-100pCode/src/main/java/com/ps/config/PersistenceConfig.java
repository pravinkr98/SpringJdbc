package com.ps.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.ps.dao")
public class PersistenceConfig {
	
	@Bean
	public JndiObjectFactoryBean createJOFB() {
		JndiObjectFactoryBean jofb=null;
		jofb=new JndiObjectFactoryBean();
		//jofb.setJndiName("java:/comp/env/DsJndi");
		jofb.setJndiName("DsJndi");
		return jofb;
	}
	
	@Bean
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jt=null;
		jt=new JdbcTemplate((DataSource) createJOFB().getObject());
		return jt;
	}

}

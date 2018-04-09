package com.niit.OnlineShoppingBackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.niit.OnlineShoppingBackend.model")
@EnableTransactionManagement
public class ApplicationContextConfig {

	
	@Bean("dataSource")
    public DataSource getDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/satyadb");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
		System.out.println("hello");
		return dataSource;
	}
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
    	builder.addProperties(getHibernateProperties());
    	builder.scanPackages("com.niit.OnlineShoppingBackend.model");
    	return builder.buildSessionFactory();
    }
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	properties.put("hibernate.format_sql", "true");
    	//properties.put("hibernate.hbm2ddl.auto", "create");
    	return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
			 
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			

		return transactionManager;
	}
	
	   
   
}
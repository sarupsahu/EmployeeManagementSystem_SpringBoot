package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jsp")
public class EmployeeConfig {
	
	@Bean // return EntityManger object to IOC
	public EntityManager getEntityManger()
	{
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EMP");
		return factory.createEntityManager();
		
	}
	
	@Bean
	public EntityTransaction getEntityTransaction()
	{
		return getEntityManger().getTransaction();
		
	}
}

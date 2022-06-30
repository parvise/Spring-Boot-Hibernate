package com.javasampleapproach.restapi.sessionFactory;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
public class HibernateUtlFactory {

	@Autowired
	public EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SessionFactory getSessionFactory(){
		if(entityManagerFactory.unwrap(SessionFactory.class)==null){
			throw new NullPointerException("Factory is not a Hibernate");
		}
		
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}

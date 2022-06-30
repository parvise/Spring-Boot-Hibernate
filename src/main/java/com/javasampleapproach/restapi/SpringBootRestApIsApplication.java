package com.javasampleapproach.restapi;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityScan({"com.javasampleapproach.restapi.model"})
@EnableJpaAuditing
public class SpringBootRestApIsApplication {
	
	@Autowired
	private static DataSource dataSource;

	public static void main(String[] args) {
		System.out.println("********"+dataSource);
		SpringApplication.run(SpringBootRestApIsApplication.class, args);
	}
}

package com.bdb.w4s.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.config.RepositoryConfiguration;

@Configuration
@ComponentScan({"com.dbd.w4s.API","com.dbd.w4s.Model","com.dbd.w4s.Services"})
@SpringBootApplication
public class W4SApplication {

	public static void main(String[] args) {
		SpringApplication.run(W4SApplication.class, args);
		
	}
}

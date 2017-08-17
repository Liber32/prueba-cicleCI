package com.bdb.w4s.Services;


import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Service;

import com.bdb.w4s.Data.UserRepository;
import com.bdb.w4s.Model.*;


@Service
@Configurable
public class AuthenticationService {

	
  
   @Autowired 
   private  UserRepository userRepository;
	
   
	public w4sResponse login(String email)
	{
		w4sResponse response= new w4sResponse();
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Beans.xml");
		 
		
		userRepository = (UserRepository) ctx.getBean("userRepository");
		
	  
		
	    
	    User cust=new User();
		
		
		//TO-DO: validar en base de datos
		
		//usuario correcto
		response.setCode("200");
		response.setType("Customer");
		response.setEntity(cust);
		
		
		
		//usuario incorrecto
		response.setCode("501");
		response.setType("Customer");
		response.setEntity(cust);
		
		
		
		
		return response;
		
	}
	
	
}

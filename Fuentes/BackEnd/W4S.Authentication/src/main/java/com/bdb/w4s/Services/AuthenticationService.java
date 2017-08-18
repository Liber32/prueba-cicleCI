package com.bdb.w4s.Services;


import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Service;

import com.bdb.w4s.Model.*;


@Service
@Configurable
public class AuthenticationService {

	
	public w4sResponse login(String email)
	{
		w4sResponse response= new w4sResponse();
		
		String[] names = {"ana","maria","juan","carlos"};
		
	    Customer cust=new Customer();
		
	   
		//TO-DO: validar en base de datos
		
	    if(email.contains("bancodebogota"))
	    {
		    	Random r= new Random();
		    int i=	r.nextInt(3);
		    String n= names[i];
		    	cust.setEmail(email);
		    	cust.setFullname("customer_"+n);
		    	cust.setPhonenumber(String.valueOf(i)+"232"+String.valueOf(i));
			//usuario correcto
			response.setCode("200");
			response.setType("Customer");
			response.setEntity(cust);
			
		
	    }
	    else
	    {		
			//usuario incorrecto
			response.setCode("501");
			response.setType("Customer");
			response.setEntity(cust);
	    }
		
		
		
		return response;
		
	}
	
	
}

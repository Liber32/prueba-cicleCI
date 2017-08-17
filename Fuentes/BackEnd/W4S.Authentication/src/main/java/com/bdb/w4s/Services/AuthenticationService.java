package com.bdb.w4s.Services;


import com.bdb.w4s.Model.*;


public class AuthenticationService {

	
	public w4sResponse login(String email)
	{
		w4sResponse response= new w4sResponse();
		Customer cust=new Customer();
		
		
		//TO-DO: validar en base de datos
		
		//usuario correcto
		response.setCode("200");
		response.setType("Customer");
		response.setEntity(cust);
		cust.setEmail(email);
		cust.setName("freddy parra");
		cust.setPhonenumber("3142278277");
		
		
		//usuario incorrecto
		response.setCode("501");
		response.setType("Customer");
		response.setEntity(cust);
		cust.setEmail(email);
		cust.setName("");
		cust.setPhonenumber("");
		
		
		
		return response;
		
	}
	
	
}

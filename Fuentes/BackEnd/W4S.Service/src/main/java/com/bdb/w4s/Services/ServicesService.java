package com.bdb.w4s.Services;


import com.bdb.w4s.Model.*;


public class ServicesService {

	
	public w4sResponse getList(String email)
	{
		w4sResponse response= new w4sResponse();
		Service serv=new Service();
		
		
		//TO-DO: validar en base de datos
		
		//usuario correcto
		response.setCode("200");
		response.setType("Customer");
		response.setEntity(serv);
		
		
		
		
		return response;
		
	}
	
	
}

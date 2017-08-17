package com.bdb.w4s.Services;


import com.bdb.w4s.Model.*;


public class CarService {

	
	public w4sResponse getList(String email)
	{
		w4sResponse response= new w4sResponse();
		Car car=new Car();
		
		
		//TO-DO: validar en base de datos
		
		//usuario correcto
		response.setCode("200");
		response.setType("Customer");
		response.setEntity(car);
		return response;
		
	}
	
	
}

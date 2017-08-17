package com.bdb.w4s.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bdb.w4s.Model.*;
import com.bdb.w4s.Services.*;

@RestController
@RequestMapping("/Service")
public class ControllerService {

	@RequestMapping(path ="/{email}", method = RequestMethod.GET)
	public w4sResponse Index (@PathVariable("email") String email)
	{
		
		ServicesService lstCust= new ServicesService();
		return lstCust.getList(email);
		
		
	}
	
	
	
	
	
	
}
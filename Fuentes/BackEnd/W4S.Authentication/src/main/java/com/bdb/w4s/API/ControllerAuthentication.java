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
@RequestMapping("/Authentication")
public class ControllerAuthentication {

	@RequestMapping(path="/{email}", method = RequestMethod.POST)
	public w4sResponse login (@PathVariable("email") String email)
	{
		
		AuthenticationService auth= new AuthenticationService();
		return auth.login(email);
		
		
	}
	
	
}

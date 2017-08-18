package com.bdb.w4s.API;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.bdb.w4s.Data.UserRepository;
import com.bdb.w4s.Model.*;
import com.bdb.w4s.Services.*;


@RestController
@RequestMapping("/Authentication")
public class ControllerAuthentication {

private final UserRepository userRepository;
	
   
   public ControllerAuthentication(UserRepository _userRepository)
   {
	  
	   
      this.userRepository = _userRepository;
	   
   }
   
	
	@RequestMapping(path="/{email}", method = POST)
	public w4sResponse login (@PathVariable("email") String email)
	{
		
		AuthenticationService auth= new AuthenticationService();
		return auth.login(email);
		
		
	}
	
	
}

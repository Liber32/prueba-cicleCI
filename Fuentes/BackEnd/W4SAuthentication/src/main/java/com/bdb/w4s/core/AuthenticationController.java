package com.bdb.w4s.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdb.w4s.core.User;

@Controller    
@RequestMapping(path="/authentication") 
public class AuthenticationController {
	@Autowired 	           
	private UserRepository userRepository;
	
	@RequestMapping(value="/login", method=RequestMethod.GET) 
	public @ResponseBody w4sResponse login (@RequestParam String email) {
		
		List<User> n = userRepository.findByEmail(email);
		
		w4sResponse response= new w4sResponse();
		
		if(n.isEmpty())
		{
			response.setCode("501");	        
			response.setType("user");
			return response;
			
		}else
		{
			response.setCode("200");	        
			response.setType("user");
			response.setEntity(n.get(0));
			return response;
			
			
			
		}
	    	
	}

	
	
	@RequestMapping(value="/register", method=RequestMethod.POST) 
	public @ResponseBody w4sResponse register (@RequestBody User user) {
		 	
		User newUser= new User();
		w4sResponse response= new w4sResponse();
		
		List<User> n = userRepository.findByEmail(user.getEmail());
		if(!n.isEmpty())
		{
			response.setCode(String.valueOf(HttpStatus.CONFLICT.value()));	        
			response.setType("El usuario ya existe");
			return response;
			
			
		}
		else
		{
			newUser.setEmail(user.getEmail());
			newUser.setName(user.getName());
			newUser.setphoneNumber(user.getphoneNumber());
			User theUser=userRepository.save(newUser);
			
			
			
			if(theUser==null)
			{
				response.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));	       
				response.setType("user");
				return response;
				
			}else
			{
				response.setCode(String.valueOf(HttpStatus.ACCEPTED.value()));	       
				response.setType("user");
				response.setEntity(theUser);
				return response;
				
				
				
			}
		}
	    	
	}
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}

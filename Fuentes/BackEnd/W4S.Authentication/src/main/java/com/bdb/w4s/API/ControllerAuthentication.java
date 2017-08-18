package com.bdb.w4s.API;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.bdb.w4s.Model.*;
import com.bdb.w4s.Services.*;


@RestController
@RequestMapping("/Authentication")
public class ControllerAuthentication {

	
	AuthenticationService _auth;
	
	public ControllerAuthentication(AuthenticationService auth)
	{
		_auth=auth;
		
		
	}
	
	@RequestMapping(path="/{email}", method = POST)
	public w4sResponse login (@PathVariable("email") String email)
	{

		return _auth.login(email);
		
		
	}
	
	
	@RequestMapping(path="/{email}", method = POST)
	public w4sResponse Register(@PathVariable("nombre") String nombre,@PathVariable("email") String emai,@PathVariable("phonenumber") String phone)
	{
		
		
		
		
		
		
	}
}

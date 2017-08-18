package com.example.demo;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/H")
public class Hello {

	@Resource
	private  test otest;
	
	
	
	@RequestMapping( method = GET)
	private String  helloword()
	{
		
		return otest.msg;
	}
}

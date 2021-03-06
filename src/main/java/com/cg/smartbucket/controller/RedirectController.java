package com.cg.smartbucket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cg.smartbucket.model.Login;
import com.cg.smartbucket.model.User;
import com.cg.smartbucket.service.ServiceProviderImpl;

@Controller
@RequestMapping("/")
public class RedirectController {
	
	@Autowired
	ServiceProviderImpl provider;
	
	@RequestMapping(value="/signuppage")
	public String signUpPage(){	
		return "newsignup";
	}
	
	@RequestMapping(value="/signup",method = RequestMethod.GET)
	public String userSignUp(@ModelAttribute User user){
		if(provider.addUser(user)== true)
		return "signupsuccess";
		else
		return "newsignup";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(@ModelAttribute Login loginDetails){
		if(provider.validateUser(loginDetails)){
			return "loginsuccess";
		}
		return "index";
			
	}
	
	@RequestMapping(value="/")
	public String loginReturn(){
		return "index";
	}
}

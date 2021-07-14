package com.vishal.gamePortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home()
	{
		return "home";    //no need of home.html
	}
	
	@RequestMapping("/showUserLogin")
	public String userLogin()
	{
		return "loginPages/loginUser";
	}
	

}

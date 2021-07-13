package com.vishal.gamePortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginLogoutController {

	
	@RequestMapping("/user/login")
	public String userLogin()
	{
		return "loginPages/loginUser";
	}
	
	
	@RequestMapping("/user/dashboard")
	public String userDashboard()
	{
		return "home";
	}
	
}

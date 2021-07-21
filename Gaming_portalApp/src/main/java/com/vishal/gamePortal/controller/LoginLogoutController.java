package com.vishal.gamePortal.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vishal.gamePortal.entities.User;
import com.vishal.gamePortal.repositories.UserRepository;

@Controller
public class LoginLogoutController {

	@Autowired
	private UserRepository userRepo;
	
	private long id=10000;
	
	@RequestMapping("/registerNewUser")
	public String registerNewUser()
	{
		return "loginPages/RegisterNewUserPage";
	}
	
	@RequestMapping("/reguserpost")
	public String reguserpost(@ModelAttribute("user") User user,ModelMap modelMap)
	{
		id++;
		long userId = id;
		user.setId(userId);
		
		try
		{
		User savedUser = userRepo.save(user);
		modelMap.addAttribute("savedUser", savedUser);
		modelMap.addAttribute("savesuccess", "Vendor is saved successfully");
		}
		catch (Exception e) {
			modelMap.addAttribute("error", "error while saving dublicate value entered");
		}

		
		
		
		
		return "loginPages/RegisterNewUserPage";

	}
	
	@RequestMapping("/user/login")
	public String userLogin()
	{
		return "loginPages/loginUser";
	}
	
	@RequestMapping("/user/dashboard")
	public String userLoginSuccess()
	{
		return "loginPages/loginSuccess";
	}
	
	
}

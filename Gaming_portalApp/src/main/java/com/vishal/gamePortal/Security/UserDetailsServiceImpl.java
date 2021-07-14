package com.vishal.gamePortal.Security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vishal.gamePortal.entities.User;
import com.vishal.gamePortal.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(username);
		//User user = userRepo.findById((long) 3).orElse(new User());
		
		System.out.println("object of user :: "+user+"    email :: "+username);
		
		if (user==null) {
			throw new UsernameNotFoundException("Could not found user !!");
		}
		
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user);
		
		
		return userDetailsImpl;
	}

}

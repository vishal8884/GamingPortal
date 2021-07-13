package com.vishal.gamePortal.Security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vishal.gamePortal.entities.User;
import com.vishal.gamePortal.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(email); 
		
		if (user==null) {
			throw new UsernameNotFoundException("Could not found user !!");
		}
		
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user);
		
		
		return userDetailsImpl;
	}

}

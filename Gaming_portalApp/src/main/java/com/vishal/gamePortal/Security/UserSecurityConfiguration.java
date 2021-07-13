package com.vishal.gamePortal.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService getUserDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(getUserDetailsService);
		dao.setPasswordEncoder(passwordEncoder());
		
		return dao;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/reguser","/","showreg").permitAll();
		
		
		http
		.antMatcher("/user/*")
		.authorizeRequests().anyRequest().hasAnyAuthority("USER")  //before it was .aunthicated   NOW ITS .hasAnyRole("ADMIN")
		.and().formLogin().loginPage("/user/login")
			.defaultSuccessUrl("/user/dashboard", true)
		.permitAll()
		.and().logout().logoutUrl("/user/logout").logoutSuccessUrl("/user/login")
		.and()
		.exceptionHandling().accessDeniedPage("/403");
		
	http.csrf().disable();
	}

}

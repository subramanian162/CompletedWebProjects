package com.subu2code.expenses_tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.subu2code.expenses_tracker.service.UserService;

/*
 * This is the Spring Security Configuration class.
 * 
 * Which will control the authenticate user's to login and view our pages.
 * 
 * This will provide the complete security for our application
 * 
 * */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService CustomUserService;
	
	/*
	 * Here I need to change my code*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
		
		/*Remove other code inside this method except the above code*/
		
		/*
		 *This code is for the purpose of checking the login locally without DB data.
		 * /
	
		/*
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("subu").password("qwert").roles("User"))
		.withUser(users.username("suresh").password("asdf").roles("User"))
		.withUser(users.username("admin").password("admin").roles("Admin"));
		*/
	}

	/*
	 * This method is used to give a security authentication to our pages
	 * Like, who are all able to access some pages and not
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/income").hasRole("USER")
		.antMatchers("/expense").hasRole("USER")
		.antMatchers("/expenseCategory").hasRole("USER")
		.antMatchers("/incomeCategory").hasRole("USER")
		.antMatchers("/spend").hasRole("USER")
		.antMatchers("/login").permitAll()
		.antMatchers("/signup").permitAll()
		.and()
			.formLogin().loginPage("/login")
			.loginProcessingUrl("/authenticateUser")
			.defaultSuccessUrl("/").permitAll()		
		.and()
			.logout().logoutUrl("/logout")
			.logoutSuccessUrl("/").permitAll(); 
	}
	
	/*
	 * Create a Bean for BCryptPasswordEncoder
	 * Which is used to BCrypt our user password
	 * */
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		System.out.println("BCryptPasswordEncoder Bean was created");
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder;
	}
	
	/*
	 * 
	 * Create a Bean for DaoAuthenticationProvider
	 * Which is used to provide an DaoAuthentication
	 * 
	 * */
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		System.out.println("DAOAuthentication provider Bean was created.");
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		/* 
		 * Add our BCryptPasswordEncoder and our Custom UserService before returning
		 * */
		
		authProvider.setUserDetailsService(CustomUserService);
		
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

}

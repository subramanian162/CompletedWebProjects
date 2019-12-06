package com.subu2code.expenses_tracker.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.subu2code.expenses_tracker.entity.User;
import com.subu2code.expenses_tracker.service.UserService;

/*
 * This is the my own Custom Authentication Success Handler class
 *  with the help of this class I can handle the request and response
 *  if the authentication was successed.
 *  
 *   Here, I handle the Success authentication
 *   
 *   If authenticated successfully, then I will redirect the reponse in to home page.
 * */

@Component
public class CustomAuthenticateSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	private UserService userService;
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
		System.out.println("Inside the Authentication Success Handler method. "
				+ "\nThis shows the authentication was successeded. "
				+ "\n so, I rediredt the user to my home page");
		
		User theUser = userService.findUserByName(auth.getName());
		
		System.out.println("The User\n Name: "+theUser.getUserName()+"\n Email: "+theUser.getUserEmail()+" is an authorized person.\n"
				+ " So,I redirect you to Home page");
		
		/*
		 * Here, I create a session and 
		 * add my current authenticated user in to that session and 
		 * then, redirect his/her to my home page
		 * 
		 * */
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user", theUser);
		
		response.sendRedirect(request.getContextPath()+"/");		
	}

}

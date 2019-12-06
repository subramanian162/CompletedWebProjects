package com.subu2code.expenses_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.subu2code.expenses_tracker.entity.ExpenseTransaction;
import com.subu2code.expenses_tracker.entity.IncomeTransaction;
import com.subu2code.expenses_tracker.service.UserService;

/*
 *This is the Transaction Controller Class 
 *
 *This will handle, POST request from the income and expense transaction page and save the data on our DB,
 *
 *With the help of our service class
 *
 * */

@Controller
public class TransactionController {

	@Autowired
	private UserService userService;
	
	/*
	 * This Method is for handling POST mapping from the client/User.
	 * 
	 *  Which is used to save the User Income Transaction Details to our DB.
	 *  
	 *  And then show the home_view to the end User.
	 * 
	 * */
	@PostMapping("/saveIncomeDetails")
	public ModelAndView saveUserIncomeTransactionDetails(IncomeTransaction incomeTransactionDetails)
	{
		ModelAndView view = new ModelAndView();

		userService.saveUserIncomeTransaction(incomeTransactionDetails);
		
		view.setViewName("home_view");
				
		return view; 
	}
	
	/*
	 * This Method is for handling POST mapping from the client/User.
	 * 
	 *  Which is used to save the User Expense Transaction Details to our DB.
	 *  
	 *  And then show the home_view to the end User.
	 * 
	 * */
	@PostMapping("/saveExpenseDetails")
	public ModelAndView saveUserExpenseTransactionDetails(ExpenseTransaction expenseTransactionDetails)
	{
		ModelAndView view = new ModelAndView();
		
		userService.saveUserExpenseTransaction(expenseTransactionDetails);
		
		view.setViewName("home_view");
		
		return view; 
	}
}

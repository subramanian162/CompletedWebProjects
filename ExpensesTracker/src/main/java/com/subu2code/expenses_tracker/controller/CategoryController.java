package com.subu2code.expenses_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.subu2code.expenses_tracker.entity.ExpenseCategory;
import com.subu2code.expenses_tracker.entity.IncomeCategory;
import com.subu2code.expenses_tracker.service.UserService;

/*
 *This is the Category Controller Class. 
 *
 *This will handle, POST request from the income and expense Category page and save the data on our DB,
 *
 *With the help of our service class
 *
 * */

@Controller
public class CategoryController {
	
	@Autowired
	private UserService userService;

	/*
	 * This Method is for handling POST mapping from the client/User.
	 * 
	 *  Which is used to save the User Income Category to our DB.
	 *  
	 *  And then show the home_view to the end User.
	 * 
	 * */
	@RequestMapping(value="/saveIncomeCategory",method=RequestMethod.POST)
	public ModelAndView saveUserIncomeCategoryDetails(String categoryName)
	{
		ModelAndView view = new ModelAndView();
				
		IncomeCategory incomeCategory = new IncomeCategory(categoryName);
		
		userService.saveUserIncomeCategory(incomeCategory);
				
		view.setViewName("home_view");
			
		return view; 
	}
	
	/*
	 * This Method is for handling POST mapping from the client/User.
	 * 
	 *  Which is used to save the User Expense Category to our DB.
	 *  
	 *  And then show the home_view to the end User.
	 * 
	 * */
	@PostMapping("/saveExpenseCategory")
	public ModelAndView saveUserExpenseCategoryDetails(String categoryName)
	{
		ModelAndView view = new ModelAndView();
		
		ExpenseCategory expenseCategory = new ExpenseCategory(categoryName);
		
		userService.saveUserExpenseCategory(expenseCategory);
		
		view.setViewName("home_view");
				
		return view; 
	}
}

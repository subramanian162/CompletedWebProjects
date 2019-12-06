package com.subu2code.expenses_tracker.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.subu2code.expenses_tracker.entity.ExpenseCategory;
import com.subu2code.expenses_tracker.entity.ExpenseTransaction;
import com.subu2code.expenses_tracker.entity.IncomeCategory;
import com.subu2code.expenses_tracker.entity.IncomeTransaction;
import com.subu2code.expenses_tracker.entity.User;
import com.subu2code.expenses_tracker.service.UserService;
import com.subu2code.expenses_tracker.user.CustomUser;
import com.subu2code.expenses_tracker.user.Report;

/*
 *This is the Controller Class 
 *
 *which is Main Controller of our application
 *
 *This will handle the Basic request and give a respective view to the end user's.
 *
 * */

@Controller
public class ExpensesTrackerController {
	
	private static final Map<String, String> MONTH_IN_NUMBER = new HashMap<>();
	
	ExpensesTrackerController()
	{
		MONTH_IN_NUMBER.put("Jan", "01");
		MONTH_IN_NUMBER.put("Feb", "02");
		MONTH_IN_NUMBER.put("Mar", "03");
		MONTH_IN_NUMBER.put("Apr", "04");
		MONTH_IN_NUMBER.put("May", "05");
		MONTH_IN_NUMBER.put("Jun", "06");
		MONTH_IN_NUMBER.put("Jul", "07");
		MONTH_IN_NUMBER.put("Aug", "08");
		MONTH_IN_NUMBER.put("Sep", "09");
		MONTH_IN_NUMBER.put("Oct", "10");
		MONTH_IN_NUMBER.put("Nov", "11");
		MONTH_IN_NUMBER.put("Dec", "12");
	}

	@Autowired
	UserService service;

	/*This is used to show the application home page*/
	
	@RequestMapping("/")
	public ModelAndView showIndex() {
		ModelAndView view = new ModelAndView();
		view.setViewName("home_view");
		return view;
	}

	/*
	 * This is used to validate the user Credentials,  
	 * And based on the result it will show the page to end user's
	 * 
	 * */
	
	@RequestMapping("/addUserCredentials")
	public ModelAndView checkUserData(@Valid @ModelAttribute("user") CustomUser customUser, BindingResult result) {
		ModelAndView view = new ModelAndView();

		if (!result.hasErrors()) {
			
			// Save the entered user data in to  the DB, If the user name was not in our DB.
			
			User user = service.findUserByName(customUser.getName());
			
			if(user==null)
			{
				service.save(customUser);
				
				System.out.println("User Added Successfully");	
			
			}
			else
			{
				System.out.println("Already have an account");
				
			}
			view.setViewName("home_view");
			
		}
		else
		{
		 view.setViewName("signup_view");
		}
		return view;
	}

	/*This is used to show the application Login page*/
	
	@RequestMapping("/login")
	public ModelAndView getLoginView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("login_view");
		return view;
	}

	/*This is used to show the application sign up page*/
	
	@RequestMapping("/signup")
	public ModelAndView getSignUpView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("signup_view");
		view.addObject("user", new CustomUser());
		System.out.println("Add CustomUser and showing the Sign up view ");
		return view;
	}

	/*This is used to show the application spend page*/
	
	@RequestMapping("/spend")
	public ModelAndView getSpendView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("spend_view");
		return view;
	}

	/*
	 * This is used to show the application Income Entry page 
	 *
	 * With user's Saved Income Category Name. 
	 * */
	
	@RequestMapping(value="/income",method=RequestMethod.GET)
	public ModelAndView getIncomeView(Principal principal) {
		
		ModelAndView view = new ModelAndView();
		
		Map<String, String> categoryNames = new HashMap<>();

		User user = service.findUserByName(principal.getName());
		
		if(user!=null)
		{
			Set<IncomeCategory> incomeCategories = user.getIncomeCategories();
			
			for(IncomeCategory category:incomeCategories)
			{
				categoryNames.put(category.getIncomeCategoryName(), category.getIncomeCategoryName());
			}
	
		}	
	    
	    view.addObject("income_categories", categoryNames);
	    view.addObject("name", new IncomeTransaction());
		
		view.setViewName("income_view");
		
		return view;
	}

	/*
	 * This is used to show the application Expense Entry page
	 * 
	 * With user's Saved Expense Category Name. 
	 * */

	@RequestMapping(value="/expense",method=RequestMethod.GET)
	public ModelAndView getExpenseView(Principal principal) {
		
		ModelAndView view = new ModelAndView();
		
		Map<String,String> categoryNames = new HashMap<>();
		

		User user = service.findUserByName(principal.getName());
		
		if(user!=null)
		{
			Set<ExpenseCategory> expenseCategories = user.getExpenseCategories();
			
			for(ExpenseCategory category:expenseCategories)
			{
				categoryNames.put(category.getExpenseCategoryName(), category.getExpenseCategoryName());
			}
	
		}	
		
		view.addObject("expense_categories", categoryNames);
		view.addObject("name", new ExpenseTransaction());
		
		view.setViewName("expense_view");
		
		return view;
	}

	/*This is used to show the application Income category Entry page*/

	@RequestMapping("/incomeCategory")
	public ModelAndView getIncomeCategoryView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("income_category_view");
		return view;
	}

	/*This is used to show the application Expense category Entry page*/

	@RequestMapping("/expenseCategory")
	public ModelAndView getExpenseCategoryView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("expense_category_view");
		return view;
	}
	
	/*Under Developing*/
	@RequestMapping("/showSpend")
	@Transactional
	public ModelAndView showInnerSpend(@RequestParam("month") String month, @RequestParam("year") Integer year,Principal principal)
	{
		ModelAndView view = new ModelAndView();
		
		String report_year = Integer.toString(year); 
		
		/********************************(Logic Begins)***********************************/
		
		Integer income = 0;
		
		Integer expense = 0;
				
		Date date = null;
		
		Set<IncomeTransaction> newIncomeTransactions = new HashSet<>();

		Set<ExpenseTransaction> newExpenseTransactions = new HashSet<>();
			
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		
		User user = service.findUserByName(principal.getName());
		
		if(user!=null)
		{
			Set<IncomeTransaction> incomeTransactions = user.getIncomeTransactions();
			

			/*Here, I filter all the IncomTransaction details based on the given month and year*/
			
			for(IncomeTransaction incomeTransaction:incomeTransactions)
			{
				
			   date = incomeTransaction.getDate();
				
				if(monthFormat.format(date).equals(ExpensesTrackerController.MONTH_IN_NUMBER.get(month)))
				{
					if(yearFormat.format(date).equals(report_year))
					{
						income=income+incomeTransaction.getAmount();
						newIncomeTransactions.add(incomeTransaction);
						
						System.out.println("Income Id: "+incomeTransaction.getId()+" Income: "+income);
					}
				}
			}
			
			Set<ExpenseTransaction> expenseTransactions = user.getExpenseTransactions();
			
			/*Here, I filter all the ExpenseTransaction details based on the given month and year*/
			for(ExpenseTransaction expenseTransaction:expenseTransactions)
			{
				
			   date = expenseTransaction.getDate();
				
				if(monthFormat.format(date).equals(ExpensesTrackerController.MONTH_IN_NUMBER.get(month)))
				{
					if(yearFormat.format(date).equals(report_year))
					{
						expense=expense+expenseTransaction.getAmount();
					    newExpenseTransactions.add(expenseTransaction);
					    
					    System.out.println("Expense Id: "+expenseTransaction.getId()+" Expense: "+expense);
					}
				}
			}
		}
		
		/*Create a Report Object and pass our filtered Data to the display view*/
		
		Report report = new Report();
		
		report.setIncome(income);
		report.setExpense(expense);
		report.setBalance(income-expense);
		report.setIncomeTransactions(newIncomeTransactions);
		report.setExpenseTransactions(newExpenseTransactions);
		
		/*************************************(Logic Ends)**********************************************/
		
		view.addObject("report", report);
		view.setViewName("inner_left");
		
		return view;
	}

}

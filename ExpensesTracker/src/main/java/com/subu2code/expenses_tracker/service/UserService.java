package com.subu2code.expenses_tracker.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.subu2code.expenses_tracker.entity.ExpenseCategory;
import com.subu2code.expenses_tracker.entity.ExpenseTransaction;
import com.subu2code.expenses_tracker.entity.IncomeCategory;
import com.subu2code.expenses_tracker.entity.IncomeTransaction;
import com.subu2code.expenses_tracker.entity.User;
import com.subu2code.expenses_tracker.user.CustomUser;

public interface UserService extends UserDetailsService{
	
	User findUserByName(String userName);
	
	void save(CustomUser user);
	
	void saveUserIncomeCategory(IncomeCategory incomeCategory);
	
	void saveUserExpenseCategory(ExpenseCategory expenseCategory);
	
	void saveUserIncomeTransaction(IncomeTransaction incomeTransaction);
	
	void saveUserExpenseTransaction(ExpenseTransaction expenseTransaction);
	
}

package com.subu2code.expenses_tracker.dao;

import com.subu2code.expenses_tracker.entity.ExpenseCategory;
import com.subu2code.expenses_tracker.entity.ExpenseTransaction;
import com.subu2code.expenses_tracker.entity.IncomeCategory;
import com.subu2code.expenses_tracker.entity.IncomeTransaction;
import com.subu2code.expenses_tracker.entity.User;

public interface UserDao {

	User findUserByName(String userName);
	
	void save(User user);
	
	void saveIncomeCategory(IncomeCategory incomeCategory);
	
	void saveExpenseCategory(ExpenseCategory expenseCategory);
	
	void saveIncomeTransaction(IncomeTransaction incomeTransaction);
	
	void saveExpenseTransaction(ExpenseTransaction expenseTransaction);	
}

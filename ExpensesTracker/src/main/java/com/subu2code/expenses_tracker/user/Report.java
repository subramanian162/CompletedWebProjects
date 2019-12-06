package com.subu2code.expenses_tracker.user;

import java.util.Set;

import com.subu2code.expenses_tracker.entity.ExpenseTransaction;
import com.subu2code.expenses_tracker.entity.IncomeTransaction;

public class Report {

	private Integer income;
	
	private Integer expense;
	
	private Set<IncomeTransaction> incomeTransactions;
	
	private Set<ExpenseTransaction> expenseTransactions;
	
	private Integer balance;

	
	public Report() {
	}
	
	
	public Report(Integer income, Integer expense, Set<IncomeTransaction> incomeTransactions,
			Set<ExpenseTransaction> expenseTransactions, Integer balance) {
		this.income = income;
		this.expense = expense;
		this.incomeTransactions = incomeTransactions;
		this.expenseTransactions = expenseTransactions;
		this.balance = balance;
	}


	public Integer getIncome() {
		return income;
	}


	public void setIncome(Integer income) {
		this.income = income;
	}


	public Integer getExpense() {
		return expense;
	}


	public void setExpense(Integer expense) {
		this.expense = expense;
	}


	public Set<IncomeTransaction> getIncomeTransactions() {
		return incomeTransactions;
	}


	public void setIncomeTransactions(Set<IncomeTransaction> incomeTransactions) {
		this.incomeTransactions = incomeTransactions;
	}


	public Set<ExpenseTransaction> getExpenseTransactions() {
		return expenseTransactions;
	}


	public void setExpenseTransactions(Set<ExpenseTransaction> expenseTransactions) {
		this.expenseTransactions = expenseTransactions;
	}


	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}

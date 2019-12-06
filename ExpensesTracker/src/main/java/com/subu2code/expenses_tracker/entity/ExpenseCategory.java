package com.subu2code.expenses_tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * This is the ExpenseCategory POJO or Entity Class
 * 
 * */

@Entity
@Table(name="expense_category")
public class ExpenseCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="expense_category_name")
	private String expenseCategoryName;

	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	public ExpenseCategory()
	{
		
	}
	
	public ExpenseCategory(String expenseCategoryName)
	{
		this.expenseCategoryName = expenseCategoryName;
	}

	
	public ExpenseCategory(String expenseCategoryName, User user) {
		super();
		this.expenseCategoryName = expenseCategoryName;
		this.user = user;
	}

	public String getExpenseCategoryName() {
		return expenseCategoryName;
	}

	public void setExpenseCategoryName(String expenseCategoryName) {
		this.expenseCategoryName = expenseCategoryName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}

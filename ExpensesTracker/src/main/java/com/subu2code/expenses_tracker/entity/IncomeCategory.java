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
 * This is the IncomeCategory POJO or Entity Class
 * 
 * */

@Entity
@Table(name="income_category")
public class IncomeCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="income_category_name")
	private String incomeCategoryName;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	public IncomeCategory()
	{
		
	}
	
	public IncomeCategory(String incomeCategoryName)
	{
		this.incomeCategoryName = incomeCategoryName;
	}

	public IncomeCategory(String incomeCategoryName, User user) {
		this.incomeCategoryName = incomeCategoryName;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIncomeCategoryName() {
		return incomeCategoryName;
	}

	public void setIncomeCategoryName(String incomeCategoryName) {
		this.incomeCategoryName = incomeCategoryName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

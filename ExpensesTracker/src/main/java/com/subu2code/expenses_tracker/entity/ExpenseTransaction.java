package com.subu2code.expenses_tracker.entity;

/*
 * This is the ExpenseTransaction POJO or Entity Class
 * 
 * */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="expense_transaction")
public class ExpenseTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id; 
	
	@Column(name="date")
	private Date date;
	
	@Column(name="expense_transaction_name")
	private String expenseTransactionName;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="notes")
	private String extraNotes;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	public ExpenseTransaction()
	{
		
	}

	public ExpenseTransaction(Date date, String expenseTransactionName, Integer amount, String extraNotes) {
		this.date = date;
		this.expenseTransactionName = expenseTransactionName;
		this.amount = amount;
		this.extraNotes = extraNotes;
	}

	public ExpenseTransaction(Date date, String expenseTransactionName, Integer amount, String extraNotes, User user) {
		this.date = date;
		this.expenseTransactionName = expenseTransactionName;
		this.amount = amount;
		this.extraNotes = extraNotes;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getExpenseTransactionName() {
		return expenseTransactionName;
	}

	public void setExpenseTransactionName(String expenseTransactionName) {
		this.expenseTransactionName = expenseTransactionName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getExtraNotes() {
		return extraNotes;
	}

	public void setExtraNotes(String extraNotes) {
		if(!extraNotes.equals("Your text here"))
		this.extraNotes = extraNotes;
	}

	@Override
	public String toString() {
		return "ExpenseTransaction [user=" + user + ", date=" + date + ", expenseTransactionName=" + expenseTransactionName
				+ ", amount=" + amount + ", extraNotes=" + extraNotes + "]";
	}
}

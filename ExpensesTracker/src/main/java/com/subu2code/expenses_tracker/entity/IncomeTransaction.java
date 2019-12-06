package com.subu2code.expenses_tracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * This is the IncomeTransaction POJO or Entity Class
 * 
 * */
@Entity
@Table(name="income_transaction")
public class IncomeTransaction {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id")
   private Integer id;
	
   @Column(name="date")
   private Date date;
	
   @Column(name="income_transaction_name")
   private String incomeTransactionName;
	
   @Column(name="amount")
   private Integer amount;
	
   @Column(name="notes")
   private String extraNotes;
	
   @ManyToOne
   @JoinColumn(name="user_id")
   private User user;
	
	public IncomeTransaction()
	{
		
	}

	public IncomeTransaction(Date date, String incomeTransactionName, Integer amount, String extraNotes) {
		this.date = date;
		this.incomeTransactionName = incomeTransactionName;
		this.amount = amount;
		this.extraNotes = extraNotes;
	}

	
	public IncomeTransaction(Date date, String incomeTransactionName, Integer amount, String extraNotes, User user) {
		this.date = date;
		this.incomeTransactionName = incomeTransactionName;
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

	public String getIncomeTransactionName() {
		return incomeTransactionName;
	}

	public void setIncomeTransactionName(String incomeTransactionName) {
		this.incomeTransactionName = incomeTransactionName;
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
}

package com.subu2code.expenses_tracker.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

/*
 * This is the User Entity Class
 * 
 * */

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="userpassword")
	private String userPassword;
	
	@Column(name="useremail")
	private String userEmail;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="users_roles",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	private Collection<Role> roles;
	
	@OneToMany(mappedBy="user" , fetch=FetchType.EAGER)
	private Set<IncomeCategory> incomeCategories;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<ExpenseCategory> expenseCategories;
	
	@OneToMany(mappedBy="user")
	private Set<IncomeTransaction> incomeTransactions;
	
	@OneToMany(mappedBy="user")
	private Set<ExpenseTransaction> expenseTransactions;
	
	public User()
	{

	}

	public User(String userName, String userEmail, String userPassword) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	
	public User(String userName, String userEmail, String userPassword, Collection<Role> roles) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.roles = roles;
	}

	
	public User(String userName, String userPassword, String userEmail, Collection<Role> roles,
			Set<IncomeCategory> incomeCategories) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.roles = roles;
		this.incomeCategories = incomeCategories;
	}

	
	public User(String userName, String userPassword, String userEmail, Collection<Role> roles,
			Set<IncomeCategory> incomeCategories, Set<ExpenseCategory> expenseCategories) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.roles = roles;
		this.incomeCategories = incomeCategories;
		this.expenseCategories = expenseCategories;
	}
	
	

	public User(String userName, String userPassword, String userEmail, Collection<Role> roles,
			Set<IncomeCategory> incomeCategories, Set<ExpenseCategory> expenseCategories,
			Set<IncomeTransaction> incomeTransactions) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.roles = roles;
		this.incomeCategories = incomeCategories;
		this.expenseCategories = expenseCategories;
		this.incomeTransactions = incomeTransactions;
	}
	
	public User(String userName, String userPassword, String userEmail, Collection<Role> roles,
			Set<IncomeCategory> incomeCategories, Set<ExpenseCategory> expenseCategories,
			Set<IncomeTransaction> incomeTransactions, Set<ExpenseTransaction> expenseTransactions) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.roles = roles;
		this.incomeCategories = incomeCategories;
		this.expenseCategories = expenseCategories;
		this.incomeTransactions = incomeTransactions;
		this.expenseTransactions = expenseTransactions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Set<IncomeCategory> getIncomeCategories() {
		return incomeCategories;
	}

	public void setIncomeCategories(Set<IncomeCategory> incomeCategories) {
		this.incomeCategories = incomeCategories;
	}

	public Set<ExpenseCategory> getExpenseCategories() {
		return expenseCategories;
	}

	public void setExpenseCategories(Set<ExpenseCategory> expenseCategories) {
		this.expenseCategories = expenseCategories;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", roles=" + roles + ", incomeCategories=" + incomeCategories + ", expenseCategories="
				+ expenseCategories + ", incomeTransactions=" + incomeTransactions + ", expenseTransactions="
				+ expenseTransactions + "]";
	}
	
}
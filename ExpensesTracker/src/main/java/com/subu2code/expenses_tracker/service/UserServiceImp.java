package com.subu2code.expenses_tracker.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.subu2code.expenses_tracker.dao.RoleDao;
import com.subu2code.expenses_tracker.dao.UserDao;
import com.subu2code.expenses_tracker.entity.ExpenseCategory;
import com.subu2code.expenses_tracker.entity.ExpenseTransaction;
import com.subu2code.expenses_tracker.entity.IncomeCategory;
import com.subu2code.expenses_tracker.entity.IncomeTransaction;
import com.subu2code.expenses_tracker.entity.User;
import com.subu2code.expenses_tracker.user.CurrentUserDetails;
import com.subu2code.expenses_tracker.user.CustomUser;

/*
 * This is the Service Implementation Class,
 * 
 *  Which helps to provide user service to our Controllers.
 *  
 *  And it was internall use the following DAO for Data Access Operation
 *  
 *  1.UserDao and
 *  2.RoleDao.
 *  
 * */
@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	UserServiceImp()
	{
		System.out.println("Custom User Service was Created\n");
	}
	
	@Transactional
	public User findUserByName(String userName) {
		
		User user = userDao.findUserByName(userName);
		
		return user;
	}

	@Transactional
	public void save(CustomUser cUser) {
		
		User user = new User();
		
		user.setUserName(cUser.getName());
		user.setUserEmail(cUser.getEmail());
		user.setUserPassword(passwordEncoder.encode(cUser.getPassword()));
		
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));
		
		userDao.save(user);
	}
	
	/*
	 * The following method was declared in UserDetailsService Class, 
	 * Here, I give a definition for it
	 * 
	 * */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userDao.findUserByName(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		CurrentUserDetails currentUserDetails = new CurrentUserDetails(user);
		
		return currentUserDetails;
	}

	@Override
	@Transactional
	public void saveUserIncomeCategory(IncomeCategory incomeCategory) {
		
		userDao.saveIncomeCategory(incomeCategory);
	}

	@Override
	@Transactional
	public void saveUserExpenseCategory(ExpenseCategory expenseCategory) {
		userDao.saveExpenseCategory(expenseCategory);
	}
	
	@Override
	@Transactional
	public void saveUserIncomeTransaction(IncomeTransaction incomeTransaction) {
		userDao.saveIncomeTransaction(incomeTransaction);
	}

	@Override
	@Transactional
	public void saveUserExpenseTransaction(ExpenseTransaction expenseTransaction) {
		userDao.saveExpenseTransaction(expenseTransaction);
	}
}

package com.subu2code.expenses_tracker.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.subu2code.expenses_tracker.entity.ExpenseCategory;
import com.subu2code.expenses_tracker.entity.ExpenseTransaction;
import com.subu2code.expenses_tracker.entity.IncomeCategory;
import com.subu2code.expenses_tracker.entity.IncomeTransaction;
import com.subu2code.expenses_tracker.entity.User;

/*
 * 
 * This is the USER Repository
 *  
 *  by which we can acces our 
 *   
 *   1.User Table,
 *   2.Income_transaction Table,
 *   3.Expense_transaction Table,
 *   4.Income_category Table,
 *   5.Expense_category Table
 *   
 *   from our DB
 * 
 * */
@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	UserDaoImp() {
		System.out.println("UserDaoImp Repository was created\n");
	}

	/*
	 * This is the method which helps to
	 * 
	 * find the user by name from the our DB and give it back to us
	 * 
	 */
	public User findUserByName(String userName) {

		User user = null;

		Session session = sessionFactory.getCurrentSession();

		// Create an Sql Query

		Query<User> query = session.createQuery("from User where userName=:uName", User.class);

		query.setParameter("uName", userName);

		try {
			user = query.getSingleResult();
		} catch (Exception ex) {
			user = null;
		}

		return user;
	}

	/*
	 * 
	 * This method helps to save our new User Data in to user Table
	 * 
	 */
	public void save(User user) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(user);
	}

	/*
	 * This is the method which helps to
	 * 
	 * save the user's Income Category int to our DB.
	 * 
	 */
	@Override
	public void saveIncomeCategory(IncomeCategory incomeCategory) {

		User currentUser = getCurrentUser();

		if (currentUser != null) {
			Session session = sessionFactory.getCurrentSession();

			Set<IncomeCategory> incomeCategories = currentUser.getIncomeCategories();

			if (incomeCategories == null)
				incomeCategories = new HashSet<>();

			incomeCategories.add(incomeCategory);

			incomeCategory.setUser(currentUser);

			currentUser.setIncomeCategories(incomeCategories);

			session.save(incomeCategory);

			session.save(currentUser);
		}
	}

	/*
	 * This is the method which helps to
	 * 
	 * save the user's Expenses Category int to our DB.
	 * 
	 */
	@Override
	public void saveExpenseCategory(ExpenseCategory expenseCategory) {
		
		User currentUser = getCurrentUser();

		if (currentUser != null) {
			Session session = sessionFactory.getCurrentSession();

			Set<ExpenseCategory> expenseCategories = currentUser.getExpenseCategories();

			if (expenseCategories == null)
				expenseCategories = new HashSet<>();

			expenseCategories.add(expenseCategory);

			expenseCategory.setUser(currentUser);

			currentUser.setExpenseCategories(expenseCategories);

			session.save(expenseCategory);

			session.save(currentUser);
		}
	}

	/*
	 * This is the method which helps to
	 * 
	 * save the user's Income Transaction Details int to our DB.
	 * 
	 */
	@Override
	public void saveIncomeTransaction(IncomeTransaction incomeTransaction) {

		User currentUser = getCurrentUser();

		if (currentUser != null) {
			Session session = sessionFactory.getCurrentSession();

			Set<IncomeTransaction> incomeTransactions = currentUser.getIncomeTransactions();

			if (incomeTransactions != null)
				incomeTransactions = new HashSet<>();

			incomeTransactions.add(incomeTransaction);

			incomeTransaction.setUser(currentUser);

			currentUser.setIncomeTransactions(incomeTransactions);

			session.save(currentUser);

			session.save(incomeTransaction);

		}
	}

	/*
	 * This is the method which helps to
	 * 
	 * save the user's Expense Transaction Details int to our DB.
	 * 
	 */
	@Override
	public void saveExpenseTransaction(ExpenseTransaction expenseTransaction) {

		User currentUser = getCurrentUser();

		if (currentUser != null) {
			Session session = sessionFactory.getCurrentSession();

			Set<ExpenseTransaction> expenseTransactions = currentUser.getExpenseTransactions();

			if (expenseTransactions == null)
				expenseTransactions = new HashSet<>();

			expenseTransactions.add(expenseTransaction);

			expenseTransaction.setUser(currentUser);

			currentUser.setExpenseTransactions(expenseTransactions);

			session.save(expenseTransaction);

			session.save(currentUser);
		}
	}

	/* Helper method for getting the current user */

	private User getCurrentUser() {
		Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User user = null;

		if (currentUser instanceof UserDetails) {
			user = findUserByName(((UserDetails) currentUser).getUsername());
		}

		return user;
	}
}

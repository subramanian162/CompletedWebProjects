package com.subu2code.expenses_tracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subu2code.expenses_tracker.entity.Role;
/*
 * 
 * This is the ROLE Repository
 *  
 *  by which we can acces our
 *  
 *   1.Role Table
 *   
 *   in the DB
 * 
 * */
@Repository
public class RoleDaoImp implements RoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	RoleDaoImp()
	{
		System.out.println("RoleDaoImp Repository was created\n");
	}
	
	/*
	 * This is the method which helps to 
	 * 
	 * find the Role by RoleName from the our DB and give it back to us
	 * 
	 * */
	public Role findRoleByName(String theRoleName) {
		
		Role role = null;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Role> query = session.createQuery("from Role where name=:roleName", Role.class);
		
		query.setParameter("roleName", theRoleName);
		
		try{
			role = query.getSingleResult();
		}
		catch(Exception ex)
		{
			role = null;
		}
		
		return role;
	}

}

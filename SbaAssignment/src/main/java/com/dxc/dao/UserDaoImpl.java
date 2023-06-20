package com.dxc.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.exception.*;
import com.dxc.model.*;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public class UserDaoImpl implements UserDAO {

	
	
	@Autowired
	SessionFactory sessionFactory;


	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		}

		private Session getSession() {
			return sessionFactory.getCurrentSession();
		}

	

	public boolean registerUser(User user) {
		getSession().save(user);
		return Boolean.TRUE;
	}

	

	public boolean updateUser(User user) {
		getSession().update(user);
		return Boolean.TRUE;
	}

	
	public User getUserById(String UserId){
		return getSession().get(User.class, UserId);
	}

	
	
	public boolean validateUser(String userId, String password) throws UserNotFoundException {
		User user =getUserById(userId);
		if(user==null) {
			throw new UserNotFoundException("UserNotFoundException");
		}else {
			if(!password.equals(user.getUserPassword())){
			return false;	
			}
		}	
		return true;		
	}

	
	public boolean deleteUser(String userId) {
		User user=getUserById(userId);
		if(user!=null) {
		getSession().delete(getUserById(userId));
		return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}

}

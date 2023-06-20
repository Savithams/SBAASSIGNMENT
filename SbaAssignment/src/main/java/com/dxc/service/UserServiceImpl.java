package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.*;
import com.dxc.exception.*;
import com.dxc.model.*;


@Service
public class UserServiceImpl implements UserService {

	UserDAO userDAO;
	
	public UserServiceImpl() {
		super();
	}
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO=userDAO;
	}

	

	public boolean registerUser(User user) throws UserAlreadyExistException {
		if( userDAO.registerUser(user)) {
			return Boolean.TRUE;			
		}else {
			throw new UserAlreadyExistException(user.getUserId()+ "already exist");
		}
	}

	

	public User updateUser(User user, String userId) throws Exception {
		userDAO.updateUser(user);
		User u= userDAO.getUserById(userId);
		if(u ==null) {
			throw new Exception();
		}
		return u;
	}

	
	 

	public User getUserById(String userId) throws UserNotFoundException {
		User user = userDAO.getUserById(userId);
		if(user==null) {
			throw new UserNotFoundException(userId+" Not found");
		}
		return user;
	}

	

	public boolean validateUser(String userId, String password) throws UserNotFoundException {
		boolean userExist=userDAO.validateUser(userId, password);
		if(!userExist)
			throw new UserNotFoundException("UserNotFoundException");
		return userExist;
	}

	
	public boolean deleteUser(String UserId) {
		return userDAO.deleteUser(UserId);
	}

}

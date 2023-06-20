package com.dxc.service;

import com.dxc.exception.*;
import com.dxc.model.*;

public interface UserService {
	
	public boolean registerUser(User user) throws UserAlreadyExistException;

	public User updateUser(User user, String id) throws Exception;

	public boolean deleteUser(String UserId);

	public boolean validateUser(String userName, String password) throws UserNotFoundException;

	public User getUserById(String userId) throws UserNotFoundException;

}

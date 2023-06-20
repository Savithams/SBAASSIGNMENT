package com.dxc.dao;

import com.dxc.exception.*;
import com.dxc.model.*;

public interface UserDAO {

	

	public boolean registerUser(User user);

	public boolean updateUser(User user);

	public User getUserById(String UserId);

	public boolean validateUser(String userName, String password) throws UserNotFoundException;

	public boolean deleteUser(String UserId);
}

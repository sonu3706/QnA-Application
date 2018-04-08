package com.stackroute.qna.services;

import java.util.List;

import com.stackroute.qna.exceptions.UserAlreadyExistsException;
import com.stackroute.qna.exceptions.UserNotFoundException;
import com.stackroute.qna.model.User;
import com.stackroute.qna.repository.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		return userDAO.saveUser(user);
	}

	@Override
	public boolean updateUser(User user) throws UserNotFoundException {
		return userDAO.updateUser(user);
	}

	@Override
	public boolean deleteUser(String userId) throws UserNotFoundException {
		return userDAO.deleteUser(userId);
	}

	@Override
	public User getUserById(String userId) throws UserNotFoundException {
		return userDAO.getUser(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

}

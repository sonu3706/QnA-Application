package com.stackroute.qna.services;

import java.util.List;

import com.stackroute.qna.model.User;
import com.stackroute.qna.exceptions.UserNotFoundException;
import com.stackroute.qna.exceptions.UserAlreadyExistsException;

public interface UserService {

	public boolean saveUser(User user) throws UserAlreadyExistsException;

	public boolean updateUser(User user) throws UserNotFoundException;

	public boolean deleteUser(String userId) throws UserNotFoundException;

	public User getUserById(String userId) throws UserNotFoundException;

	public List<User> getAllUsers();

}

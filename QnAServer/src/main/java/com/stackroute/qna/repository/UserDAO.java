package com.stackroute.qna.repository;

import com.stackroute.qna.exceptions.UserAlreadyExistsException;
import com.stackroute.qna.exceptions.UserNotFoundException;
import com.stackroute.qna.model.User;

import java.util.List;

public interface UserDAO {

	public boolean saveUser(User user) throws UserAlreadyExistsException;

	public boolean updateUser(User user) throws UserNotFoundException;

	public boolean deleteUser(String userId) throws UserNotFoundException;

	public User getUser(String userId) throws UserNotFoundException;

	public List<User> getAllUsers();

}

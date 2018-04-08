package com.stackroute.qna.repository;

import com.stackroute.qna.model.User;
import com.stackroute.qna.exceptions.UserAlreadyExistsException;
import com.stackroute.qna.exceptions.UserNotFoundException;

import javax.persistence.PersistenceContext;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		if (entityManager.find(User.class, user.getUserId()) != null) {
			throw new UserAlreadyExistsException("Registration failed, user already exists");
		}
		entityManager.persist(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) throws UserNotFoundException {
		if (entityManager.find(User.class, user.getUserId()) == null) {
			throw new UserNotFoundException("Can not update User , User doesnot exists");
		}
		entityManager.merge(user);
		return true;
	}

	@Override
	public boolean deleteUser(String userId) throws UserNotFoundException {
		User user = entityManager.find(User.class, userId);
		if (user == null) {
			throw new UserNotFoundException("Can not delete User , User does not exists");
		}
		entityManager.remove(user);
		return true;
	}

	@Override
	public User getUser(String userId) throws UserNotFoundException {
		User user = entityManager.find(User.class, userId);
		if (user == null) {
			throw new UserNotFoundException("User does not Exists!");
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return entityManager.createQuery("From User").getResultList();
	}

}

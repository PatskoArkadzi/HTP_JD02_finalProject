package by.htp.cinema.service.impl;

import java.util.List;

import by.htp.cinema.dao.UserDao;
import by.htp.cinema.domain.User;
import by.htp.cinema.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao;

	public UserServiceImpl() {
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.readAll();
	}

	@Override
	public void createUser(User user) {
		userDao.create(user);
	}

	@Override
	public User readUser(int id) {
		return userDao.read(id);

	}

	@Override
	public User readUser(String login, String password) {
		return userDao.read(login, password);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

}

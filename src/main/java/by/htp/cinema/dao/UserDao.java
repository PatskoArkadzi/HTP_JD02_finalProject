package by.htp.cinema.dao;

import by.htp.cinema.domain.User;

public interface UserDao extends BaseDao<User> {

	public User read(String login, String password);

	// TODO add specific methods
}

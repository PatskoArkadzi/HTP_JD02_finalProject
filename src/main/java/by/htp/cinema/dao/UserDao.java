package by.htp.cinema.dao;

import by.htp.cinema.domain.User;

public interface UserDao extends BaseDao<User> {

	/*
	 * User read(String login);
	 * 
	 * User read(String email);
	 */

	User read(String[] parametres, Object[] values);

	// TODO add specific methods
}

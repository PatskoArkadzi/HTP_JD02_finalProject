package by.htp.cinema.dao;

import java.util.List;

import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.User;

public interface UserDao extends BaseDao<User> {

	/*
	 * User read(String login);
	 * 
	 * User read(String email);
	 */

	User read(String[] parametres, Object[] values);

	List<User> readAllUsersWhereRoleIdPresent(int genreId);

	// TODO add specific methods
}

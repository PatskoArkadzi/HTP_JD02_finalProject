package by.htp.cinema.dao;

import java.util.List;
import java.util.Map;

import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.User;

public interface UserDao extends BaseDao<User> {

	/*
	 * User read(String login);
	 * 
	 * User read(String email);
	 */

	User readAllWhereEq(Map<String,Object> map);

	List<User> readAllUsersWhereRoleIdPresent(int genreId);

	// TODO add specific methods
}

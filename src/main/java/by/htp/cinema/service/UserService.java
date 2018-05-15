package by.htp.cinema.service;

import java.util.List;

import by.htp.cinema.domain.User;

public interface UserService extends Service {

	List<User> getUserList();

	void createUser(User user);

	User readUser(int id);

	User readUser(String login, String password);

	void updateUser(User user);

	void deleteUser(User user);
}

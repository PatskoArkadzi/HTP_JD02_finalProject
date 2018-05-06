package by.htp.cinema.web.action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.cinema.dao.RoleDao;
import by.htp.cinema.dao.UserDao;
import by.htp.cinema.dao.impl.RoleDaoHibernateImpl;
import by.htp.cinema.dao.impl.UserDaoHibernateImpl;
import by.htp.cinema.domain.Role;
import by.htp.cinema.domain.User;
import by.htp.cinema.web.action.BaseAction;
import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;

public class CrudUserAction implements BaseAction {

	UserDao userDao = new UserDaoHibernateImpl();
	RoleDao roleDao = new RoleDaoHibernateImpl();

	@Override
	public String executeAction(HttpServletRequest req) {
		List<User> users = userDao.readAll();
		List<Role> roles = roleDao.readAll();
		req.setAttribute(REQUEST_PARAM_USER_LIST, users);
		req.setAttribute(REQUEST_PARAM_ROLE_LIST, roles);
		if (isPost(req)) {
			String crudCommand = req.getParameter(REQUEST_PARAM_CRUD_COMMAND);
			validateRequestParamNotNull(crudCommand);
			User user;

			System.out.println(req.getParameter(REQUEST_PARAM_USER_ROLE));

			switch (crudCommand) {
			case CRUD_OPERATION_NAME_CREATE:
				user = buildUser(req);
				userDao.create(user);
				break;
			case CRUD_OPERATION_NAME_READ:
				int roleId = getInt(req.getParameter(REQUEST_PARAM_USER_ID));
				user = userDao.read(roleId);
				req.setAttribute(REQUEST_PARAM_FOUND_USER, user);
				break;
			case CRUD_OPERATION_NAME_UPDATE:
				user = buildUser(req);
				userDao.update(user);
				break;
			case CRUD_OPERATION_NAME_DELETE:
				user = buildUser(req);
				userDao.delete(user);
				break;
			default:
				return PAGE_ERROR;
			}
		}
		return PAGE_ADMIN_CRUD_USER;
	}

	private User buildUser(HttpServletRequest req) {
		String id = req.getParameter(REQUEST_PARAM_USER_ID);
		String login = req.getParameter(REQUEST_PARAM_USER_LOGIN);
		String email = req.getParameter(REQUEST_PARAM_USER_EMAIL);
		String password = req.getParameter(REQUEST_PARAM_USER_PASSWORD);
		String roleId = req.getParameter(REQUEST_PARAM_ROLE_ID);
		System.out.println(id+" "+login+" "+email+" "+password+" "+roleId);
		validateRequestParamNotNull(id, login, email, password, roleId);

		User user = new User();
		Role role = roleDao.read(getInt(roleId));
		user.setId(getInt(id));
		user.setLogin(login);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		return user;
	}
}

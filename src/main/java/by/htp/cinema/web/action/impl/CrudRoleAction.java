package by.htp.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.cinema.dao.RoleDao;
import by.htp.cinema.dao.impl.RoleDaoHibernateImpl;
import by.htp.cinema.domain.Role;
import by.htp.cinema.web.action.BaseAction;

import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;

import java.util.List;

public class CrudRoleAction implements BaseAction {

	RoleDao roleDao = new RoleDaoHibernateImpl();

	@Override
	public String executeAction(HttpServletRequest req) {
		List<Role> roles = roleDao.readAll();
		req.setAttribute(REQUEST_PARAM_ROLE_LIST, roles);
		if (isPost(req)) {
			String crudCommand = req.getParameter(REQUEST_PARAM_CRUD_COMMAND);
			validateRequestParamNotNull(crudCommand);
			Role role;

			switch (crudCommand) {
			case CRUD_OPERATION_NAME_CREATE:
				role = buildRole(req);
				roleDao.create(role);
				break;
			case CRUD_OPERATION_NAME_READ:
				int roleId = getInt(req.getParameter(REQUEST_PARAM_ROLE_ID));
				role = roleDao.read(roleId);
				req.setAttribute(REQUEST_PARAM_FOUND_ROLE, role);
				break;
			case CRUD_OPERATION_NAME_UPDATE:
				role = buildRole(req);
				roleDao.update(role);
				break;
			case CRUD_OPERATION_NAME_DELETE:
				role = buildRole(req);
				roleDao.delete(role);
				break;
			default:
				return PAGE_ERROR;
			}
		}
		return PAGE_ADMIN_CRUD_ROLE;
	}

	private Role buildRole(HttpServletRequest req) {
		String id = req.getParameter(REQUEST_PARAM_ROLE_ID);
		String roleName = req.getParameter(REQUEST_PARAM_ROLE_NAME);
		validateRequestParamNotNull(id, roleName);
		Role role = new Role();
		role.setId(getInt(id));
		role.setRoleName(roleName);
		return role;
	}
}

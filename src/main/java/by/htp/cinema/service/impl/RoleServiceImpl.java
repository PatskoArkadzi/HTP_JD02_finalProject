package by.htp.cinema.service.impl;

import java.util.List;

import by.htp.cinema.dao.RoleDao;
import by.htp.cinema.domain.Role;
import by.htp.cinema.service.RoleService;

public class RoleServiceImpl implements RoleService {
	RoleDao roleDao;

	public RoleServiceImpl() {
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Role> getRoleList() {
		return roleDao.readAll();
	}

	@Override
	public void createRole(Role role) {
		roleDao.create(role);
	}

	@Override
	public Role readRole(int id) {
		return roleDao.read(id);

	}

	@Override
	public void updateRole(Role role) {
		roleDao.update(role);

	}

	@Override
	public void deleteRole(Role role) {
		roleDao.delete(role);
	}

}

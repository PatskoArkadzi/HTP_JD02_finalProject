package by.htp.cinema;

import by.htp.cinema.dao.RoleDao;
import by.htp.cinema.dao.impl.RoleDaoHibernateImpl;
import by.htp.cinema.domain.Role;
import by.htp.cinema.domain.User;

public class Runner {

	public static void main(String[] args) {
		RoleDao roleDao=new RoleDaoHibernateImpl();
		Role role=roleDao.read(2);
		for(User user:role.getUsers())
			System.out.println(user);

	}
}

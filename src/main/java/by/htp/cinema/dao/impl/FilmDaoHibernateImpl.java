package by.htp.cinema.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.domain.Film;

public class FilmDaoHibernateImpl implements FilmDao {

	@Override
	public void create(Film entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Film read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Film entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Film entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Film> readAll() {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Film.class);
		List<Film> films = criteria.list();
		session.close();
		return films;
	}

}

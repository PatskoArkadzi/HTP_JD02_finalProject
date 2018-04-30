package by.htp.cinema.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.dao.FilmSessionDao;
import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.FilmSession;

public class FilmSessionDaoHibernateImpl implements FilmSessionDao {

	@Override
	public void create(FilmSession entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public FilmSession read(int id) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		FilmSession filmSession = (FilmSession) session.get(FilmSession.class, id);
		session.close();
		return filmSession;
	}

	@Override
	public void update(FilmSession entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(FilmSession entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<FilmSession> readAll() {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(FilmSession.class);
		List<FilmSession> filmSessions = criteria.list();
		session.close();
		return filmSessions;
	}

}

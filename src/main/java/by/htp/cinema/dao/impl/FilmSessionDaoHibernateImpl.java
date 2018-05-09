package by.htp.cinema.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import by.htp.cinema.dao.FilmSessionDao;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Role;

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
		Criteria criteria = session.createCriteria(FilmSession.class);
		criteria.add(Restrictions.eq("id", id));
		FilmSession filmSession = (FilmSession) criteria.uniqueResult();
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
		// delete duplicates in "left outer join" query
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<FilmSession> filmSessions = criteria.list();
		session.close();
		return filmSessions;
	}

	@Override
	public List<FilmSession> readAll(String sortingColumn) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(FilmSession.class);
		// delete duplicates in "left outer join" query
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc(sortingColumn));
		List<FilmSession> filmSessions = criteria.list();
		session.close();
		return filmSessions;
	}

	@Override
	public List<FilmSession> readAllWhereEq(String[] parametres, Object[] values) {
		if (parametres.length != values.length)
			throw new IllegalArgumentException();
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(FilmSession.class);
		for (int i = 0; i < parametres.length; i++)
			criteria.add(Restrictions.eq(parametres[i], values[i]));
		// delete duplicates in "left outer join" query
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<FilmSession> filmSessions = criteria.list();
		session.close();
		return filmSessions;
	}

}

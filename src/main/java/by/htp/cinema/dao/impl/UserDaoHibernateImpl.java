package by.htp.cinema.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import by.htp.cinema.dao.UserDao;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.User;

@Component
public class UserDaoHibernateImpl implements UserDao {

	@Override
	public void create(User entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public User read(int id) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		User user = (User) criteria.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public User read(String[] parametres, Object[] values) {
		if (parametres.length != values.length)
			throw new IllegalArgumentException();
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		for (int i = 0; i < parametres.length; i++)
			criteria.add(Restrictions.eq(parametres[i], values[i]));
		User user = (User) criteria.uniqueResult();
		session.close();
		return user;
	}

	/*
	 * public User read(String login) { SessionFactory factory =
	 * SessionFactoryManager.getSessionFactory(); Session session =
	 * factory.openSession(); Criteria criteria =
	 * session.createCriteria(User.class); criteria.add(Restrictions.eq("login",
	 * login)); User user = (User) criteria.uniqueResult(); session.close(); return
	 * user; }
	 * 
	 * @Override public User read(String login, String password) { SessionFactory
	 * factory = SessionFactoryManager.getSessionFactory(); Session session =
	 * factory.openSession(); Criteria criteria =
	 * session.createCriteria(User.class); criteria.add(Restrictions.eq("login",
	 * login)); criteria.add(Restrictions.eq("password", password)); User user =
	 * (User) criteria.uniqueResult(); session.close(); return user; }
	 */

	@Override
	public void update(User entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(User entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<User> readAll() {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("id"));
		List<User> users = criteria.list();
		session.close();
		return users;
	}

	@Override
	public List<User> readAll(String sortingColumn) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc(sortingColumn));
		List<User> users = criteria.list();
		session.close();
		return users;
	}
}

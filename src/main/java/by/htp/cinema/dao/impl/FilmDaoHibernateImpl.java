package by.htp.cinema.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.Genre;
import by.htp.cinema.domain.Role;

@Component
public class FilmDaoHibernateImpl implements FilmDao {

	@Override
	public void create(Film entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Film read(int id) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Film.class);
		criteria.add(Restrictions.eq("id", id));
		Film film = (Film) criteria.uniqueResult();
		session.close();
		return film;
	}

	@Override
	public void update(Film entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Film entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Film> readAll() {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Film.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Film> films = criteria.list();
		session.close();
		return films;
	}

	@Override
	public List<Film> readAll(String sortingColumn) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Film.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc(sortingColumn));
		List<Film> films = criteria.list();
		session.close();
		return films;
	}

	@Override
	public List<Film> readAllWhereEq(String[] parametres, Object[] values) {
		if (parametres.length != values.length)
			throw new IllegalArgumentException();
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Film.class);
		for (int i = 0; i < parametres.length; i++)
			criteria.add(Restrictions.eq(parametres[i], values[i]));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Film> films = criteria.list();
		session.close();
		return films;
	}

	@Override
	public List<Film> readAllFilmsWhereGenreIdPresent(int genreId) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("select f from Film f inner join f.genres g where g.id=:idGenre")
				.setParameter("idGenre", genreId);
		List<Film> films = query.list();
		session.close();
		return films;
	}
}

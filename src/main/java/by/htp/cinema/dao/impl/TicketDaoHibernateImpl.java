package by.htp.cinema.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import by.htp.cinema.dao.TicketDao;
import by.htp.cinema.domain.Ticket;


public class TicketDaoHibernateImpl implements TicketDao {
	
	@Override
	public void create(Ticket entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}

	}

	@Override
	public Ticket read(int id) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.add(Restrictions.eq("id", id));
		Ticket ticket = (Ticket) criteria.uniqueResult();
		if (session.isOpen()) {
			session.close();
		}
		return ticket;
	}

	@Override
	public void update(Ticket entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public void delete(Ticket entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(entity);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public List<Ticket> readAll() {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Ticket.class);
		// delete duplicates in "left outer join" query
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Ticket> tickets = criteria.list();
		if (session.isOpen()) {
			session.close();
		}
		return tickets;
	}

	@Override
	public List<Ticket> readAll(String sortingColumn) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Ticket.class);
		// delete duplicates in "left outer join" query
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc(sortingColumn));
		List<Ticket> tickets = criteria.list();
		if (session.isOpen()) {
			session.close();
		}
		return tickets;
	}

}
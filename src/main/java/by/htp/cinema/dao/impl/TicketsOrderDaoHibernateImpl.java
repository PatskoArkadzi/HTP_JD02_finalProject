package by.htp.cinema.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import by.htp.cinema.dao.TicketsOrderDao;
import by.htp.cinema.domain.TicketsOrder;

public class TicketsOrderDaoHibernateImpl implements TicketsOrderDao {
	
	@Override
	public void create(TicketsOrder entity) {
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
	public TicketsOrder read(int id) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(TicketsOrder.class);
		criteria.add(Restrictions.eq("id", id));
		TicketsOrder ticketOrder = (TicketsOrder) criteria.uniqueResult();
		if (session.isOpen()) {
			session.close();
		}
		return ticketOrder;
	}

	@Override
	public void update(TicketsOrder entity) {
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
	public void delete(TicketsOrder entity) {
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
	public List<TicketsOrder> readAll() {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(TicketsOrder.class);
		// delete duplicates in "left outer join" query
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<TicketsOrder> ticketOrders = criteria.list();
		if (session.isOpen()) {
			session.close();
		}
		return ticketOrders;
	}

	@Override
	public List<TicketsOrder> readAll(String sortingColumn) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(TicketsOrder.class);
		// delete duplicates in "left outer join" query
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc(sortingColumn));
		List<TicketsOrder> ticketOrders = criteria.list();
		if (session.isOpen()) {
			session.close();
		}
		return ticketOrders;
	}

}

package by.htp.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.cinema.dao.TicketsOrderDao;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;
import by.htp.cinema.domain.TicketsOrder;
import by.htp.cinema.domain.User;
import by.htp.cinema.service.TicketsOrderService;

@Service
public class TicketsOrderServiceImpl implements TicketsOrderService {

	@Autowired
	TicketsOrderDao ticketsOrderDao;

	public TicketsOrderServiceImpl() {
	}

	public TicketsOrderDao getTicketsOrderDao() {
		return ticketsOrderDao;
	}

	public void setTicketsOrderDao(TicketsOrderDao ticketsOrderDao) {
		this.ticketsOrderDao = ticketsOrderDao;
	}

	@Override
	public List<TicketsOrder> getTicketsOrderList() {
		return ticketsOrderDao.readAll("id");
	}

	@Override
	public void createTicketsOrder(TicketsOrder ticketsOrder) {
		ticketsOrderDao.create(ticketsOrder);
	}

	@Override
	public TicketsOrder readTicketsOrder(int id) {
		return ticketsOrderDao.read(id);
	}

	@Override
	public void updateTicketsOrder(TicketsOrder ticketsOrder) {
		ticketsOrderDao.update(ticketsOrder);
	}

	@Override
	public void deleteTicketsOrder(TicketsOrder ticketsOrder) {
		ticketsOrderDao.delete(ticketsOrder);
	}

	@Override
	public TicketsOrder readUserNonPaidOrder(User user) {
		for (TicketsOrder order : ticketsOrderDao.readAll("user", user))
			if (!order.isPaid())
				return order;
		return null;
	}

	@Override
	public TicketsOrder readOrderWhereSeatPresent(Seat seat, FilmSession filmSession) {
		return ticketsOrderDao.read(seat, filmSession);
	}

	@Override
	public TicketsOrder readCurrentUserNonPaidOrder(User user) {
		return ticketsOrderDao.read(user);
	}
}

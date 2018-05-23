package by.htp.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.cinema.dao.TicketsOrderDao;
import by.htp.cinema.domain.TicketsOrder;
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
		return ticketsOrderDao.readAll();
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
}

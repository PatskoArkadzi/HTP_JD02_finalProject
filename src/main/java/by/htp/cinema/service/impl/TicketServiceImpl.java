package by.htp.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.cinema.dao.TicketDao;
import by.htp.cinema.domain.Ticket;
import by.htp.cinema.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDao ticketDao;

	public TicketServiceImpl() {
	}

	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	public List<Ticket> getTicketList() {
		return ticketDao.readAll("id");
	}

	@Override
	public void createTicket(Ticket ticket) {
		ticketDao.create(ticket);
	}

	@Override
	public Ticket readTicket(int id) {
		return ticketDao.read(id);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		ticketDao.update(ticket);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		ticketDao.delete(ticket);
	}
}

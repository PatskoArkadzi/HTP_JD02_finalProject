package by.htp.cinema.dao;

import java.util.List;

import by.htp.cinema.domain.Seat;
import by.htp.cinema.domain.Ticket;

public interface TicketDao extends BaseDao<Ticket> {

	List<Ticket> readAll(String property, Object value);
	// TODO add specific methods
}

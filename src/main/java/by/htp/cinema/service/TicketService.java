package by.htp.cinema.service;

import java.util.List;

import by.htp.cinema.domain.Seat;
import by.htp.cinema.domain.Ticket;
import by.htp.cinema.domain.User;

public interface TicketService extends Service {

	List<Ticket> getTicketList();

	void createTicket(Ticket ticket);

	Ticket readTicket(int id);

	void updateTicket(Ticket ticket);

	void deleteTicket(Ticket ticket);

	boolean isAnyTicketContainsSeat(Seat seat);
}

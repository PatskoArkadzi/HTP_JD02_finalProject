package by.htp.cinema.service;

import java.util.List;

import by.htp.cinema.domain.TicketsOrder;

public interface TicketsOrderService extends Service {

	List<TicketsOrder> getTicketsOrderList();

	void createTicketsOrder(TicketsOrder ticketsOrder);

	TicketsOrder readTicketsOrder(int id);

	void updateTicketsOrder(TicketsOrder ticketsOrder);

	void deleteTicketsOrder(TicketsOrder ticketsOrder);
}

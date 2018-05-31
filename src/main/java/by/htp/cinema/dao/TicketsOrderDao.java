package by.htp.cinema.dao;

import java.util.List;

import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;
import by.htp.cinema.domain.TicketsOrder;

public interface TicketsOrderDao extends BaseDao<TicketsOrder> {

	List<TicketsOrder> readAll(String string, Object object);

	TicketsOrder readOrderWhereSeatPresent(Seat seat, FilmSession filmSession);

	// TODO add specific methods
}

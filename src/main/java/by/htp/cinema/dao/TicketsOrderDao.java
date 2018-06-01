package by.htp.cinema.dao;

import java.util.List;

import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;
import by.htp.cinema.domain.TicketsOrder;
import by.htp.cinema.domain.User;

public interface TicketsOrderDao extends BaseDao<TicketsOrder> {

	List<TicketsOrder> readAll(String string, Object object);

	TicketsOrder read(Seat seat, FilmSession filmSession);

	TicketsOrder read(User user);


	// TODO add specific methods
}

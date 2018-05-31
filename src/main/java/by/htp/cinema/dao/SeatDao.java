package by.htp.cinema.dao;

import by.htp.cinema.domain.Seat;

public interface SeatDao extends BaseDao<Seat> {

	Seat read(int row, int number);
	//TODO add specific methods
}

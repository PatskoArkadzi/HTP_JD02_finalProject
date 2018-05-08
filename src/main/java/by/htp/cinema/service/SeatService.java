package by.htp.cinema.service;

import java.util.List;

import by.htp.cinema.domain.Seat;

public interface SeatService extends Service {

	List<Seat> getSeatList();

	void createSeat(Seat seat);

	Seat readSeat(int id);

	void updateSeat(Seat seat);

	void deleteSeat(Seat seat);
}

package by.htp.cinema.service;

import java.util.List;

import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;

public interface SeatService extends Service {

	List<Seat> getSeatList();

	void createSeat(Seat seat);

	Seat readSeat(int id);

	void updateSeat(Seat seat);

	void deleteSeat(Seat seat);

	Seat readSeat(int row, int number);

	Seat setSeatState(Seat seat, FilmSession filmSession);

	boolean isSeatExist(Seat seat);

	boolean isSeatExist(int id);
}

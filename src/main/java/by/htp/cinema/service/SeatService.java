package by.htp.cinema.service;

import java.util.List;

import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;

public interface SeatService extends Service {

	List<Seat> getSeatList();

	void createSeat(Seat seat);

	Seat readSeat(int id);

	Seat readSeat(int row, int number);

	void updateSeat(Seat seat);

	void deleteSeat(Seat seat);

	Seat setSeatState(Seat seat, FilmSession filmSession);

	boolean isSeatExist(Seat seat);

	boolean isSeatExist(int id);

	boolean isSeatFree(Seat seat, FilmSession filmSession);
}

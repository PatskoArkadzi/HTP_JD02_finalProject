package by.htp.cinema.service;

import java.util.List;

import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;

public interface FilmSessionService extends Service {

	List<FilmSession> getFilmSessionList();

	List<FilmSession> getFilmSessionListWhereSeatNotFree(Seat seat);

	List<FilmSession> getChosenFilmFilmSessionList(Film film);

	void createFilmSession(FilmSession filmSession);

	FilmSession readFilmSession(int id);

	void updateFilmSession(FilmSession filmSession);

	void deleteFilmSession(FilmSession filmSession);

	boolean isAnyTicketRelatedToFilmSession(int filmSessionId);

}

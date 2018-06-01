package by.htp.cinema.dao;

import java.util.List;
import java.util.Map;

import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;

public interface FilmSessionDao extends BaseDao<FilmSession> {

	List<FilmSession> readAll(Map<String,Object> map);

	List<FilmSession> readAll(String property, Object value);

	List<FilmSession> readAllWhereSeatNotFree(Seat seat);
}

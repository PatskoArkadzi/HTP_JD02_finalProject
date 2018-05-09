package by.htp.cinema.dao;

import java.util.List;

import by.htp.cinema.domain.FilmSession;

public interface FilmSessionDao extends BaseDao<FilmSession> {

	List<FilmSession> readAllWhereEq(String[] parametre, Object[] value);
}

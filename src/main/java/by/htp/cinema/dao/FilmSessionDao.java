package by.htp.cinema.dao;

import java.util.List;
import java.util.Map;

import by.htp.cinema.domain.FilmSession;

public interface FilmSessionDao extends BaseDao<FilmSession> {

	List<FilmSession> readAllWhereEq(Map<String,Object> map);
}

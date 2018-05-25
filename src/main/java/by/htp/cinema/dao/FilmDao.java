package by.htp.cinema.dao;

import java.util.List;

import by.htp.cinema.domain.Film;

public interface FilmDao extends BaseDao<Film> {

	List<Film> readAllWhereEq(String[] parametres, Object[] values);
	//TODO add specific methods

	List<Film> readAllFilmsWhereGenreIdPresent(int genreId);
}

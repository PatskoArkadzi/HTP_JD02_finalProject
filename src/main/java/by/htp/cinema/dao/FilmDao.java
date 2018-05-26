package by.htp.cinema.dao;

import java.util.List;

import by.htp.cinema.domain.Film;

public interface FilmDao extends BaseDao<Film> {

	List<Film> readAllWhereEq(String[] parametres, Object[] values);

	List<Film> readAllFilmsWhereGenreIdPresent(int genreId);

	// TODO add specific methods
}

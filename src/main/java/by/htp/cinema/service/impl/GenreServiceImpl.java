package by.htp.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.dao.GenreDao;
import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.Genre;
import by.htp.cinema.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreDao genreDao;
	@Autowired
	FilmDao filmDao;

	public GenreServiceImpl() {
	}

	public GenreDao getGenreDao() {
		return genreDao;
	}

	public void setGenreDao(GenreDao genreDao) {
		this.genreDao = genreDao;
	}

	public FilmDao getFilmDao() {
		return filmDao;
	}

	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}

	@Override
	public List<Genre> getGenreList() {
		return genreDao.readAll("id");
	}

	@Override
	public void createGenre(Genre genre) {
		genreDao.create(genre);
	}

	@Override
	public Genre readGenre(int id) {
		return genreDao.read(id);

	}

	@Override
	public void updateGenre(Genre genre) {
		genreDao.update(genre);

	}

	@Override
	public void deleteGenre(Genre genre) {
		genreDao.delete(genre);
	}

	@Override
	public boolean isAnyFilmContainGenre(int id) {
		List<Film> films = filmDao.readAllFilmsWhereGenreIdPresent(id);
		return films.size() != 0;
	}
}

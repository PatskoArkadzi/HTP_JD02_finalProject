package by.htp.cinema.service.impl;

import java.util.List;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.domain.Film;
import by.htp.cinema.service.FilmService;

public class FilmServiceImpl implements FilmService {

	FilmDao filmDao;

	public FilmServiceImpl() {
	}

	public FilmDao getFilmDao() {
		return filmDao;
	}

	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}

	@Override
	public List<Film> getFilmList() {
		return filmDao.readAll();
	}

	@Override
	public void createFilm(Film film) {
		filmDao.create(film);
	}

	@Override
	public Film readFilm(int id) {
		return filmDao.read(id);
	}

	@Override
	public void updateFilm(Film film) {
		filmDao.update(film);
	}

	@Override
	public void deleteFilm(Film film) {
		filmDao.delete(film);
	}
}

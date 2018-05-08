package by.htp.cinema.service.impl;

import java.util.List;

import by.htp.cinema.dao.FilmSessionDao;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.service.FilmSessionService;

public class FilmSessionServiceImpl implements FilmSessionService {

	FilmSessionDao filmSessionDao;

	public FilmSessionServiceImpl() {
	}

	public FilmSessionDao getFilmSessionDao() {
		return filmSessionDao;
	}

	public void setFilmSessionDao(FilmSessionDao filmSessionDao) {
		this.filmSessionDao = filmSessionDao;
	}

	@Override
	public List<FilmSession> getFilmSessionList() {
		return filmSessionDao.readAll();
	}

	@Override
	public void createFilmSession(FilmSession filmSession) {
		filmSessionDao.create(filmSession);
	}

	@Override
	public FilmSession readFilmSession(int id) {
		return filmSessionDao.read(id);
	}

	@Override
	public void updateFilmSession(FilmSession filmSession) {
		filmSessionDao.update(filmSession);
	}

	@Override
	public void deleteFilmSession(FilmSession filmSession) {
		filmSessionDao.delete(filmSession);
	}
}

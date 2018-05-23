package by.htp.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.cinema.dao.GenreDao;
import by.htp.cinema.domain.Genre;
import by.htp.cinema.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	GenreDao genreDao;

	public GenreServiceImpl() {
	}

	public GenreDao getGenreDao() {
		return genreDao;
	}

	public void setGenreDao(GenreDao genreDao) {
		this.genreDao = genreDao;
	}

	@Override
	public List<Genre> getGenreList() {
		return genreDao.readAll();
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
}

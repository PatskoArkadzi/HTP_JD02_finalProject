package by.htp.cinema.web.action.impl;

import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.dao.GenreDao;
import by.htp.cinema.dao.impl.FilmDaoHibernateImpl;
import by.htp.cinema.dao.impl.GenreDaoHibernateImpl;
import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.Genre;
import by.htp.cinema.web.action.BaseAction;

public class CrudFilmAction implements BaseAction {

	FilmDao filmDao = new FilmDaoHibernateImpl();
	GenreDao genreDao = new GenreDaoHibernateImpl();

	@Override
	public String executeAction(HttpServletRequest req) {
		List<Film> films = filmDao.readAll();
		List<Genre> genres = genreDao.readAll();
		req.setAttribute(REQUEST_PARAM_FILM_LIST, films);
		req.setAttribute(REQUEST_PARAM_GENRE_LIST, genres);
		if (isPost(req)) {
			String crudCommand = req.getParameter(REQUEST_PARAM_CRUD_COMMAND);
			validateRequestParamNotNull(crudCommand);
			Film film;

			switch (crudCommand) {
			case CRUD_OPERATION_NAME_CREATE:
				film = buildFilm(req);
				filmDao.create(film);
				break;
			case CRUD_OPERATION_NAME_READ:
				String filmId = req.getParameter(REQUEST_PARAM_FILM_ID);
				validateRequestParamNotNull(filmId);
				film = filmDao.read(getInt(filmId));
				req.setAttribute(REQUEST_PARAM_FOUND_FILM, film);
				break;
			case CRUD_OPERATION_NAME_UPDATE:
				film = buildFilm(req);
				filmDao.update(film);
				break;
			case CRUD_OPERATION_NAME_DELETE:
				film = buildFilm(req);
				filmDao.delete(film);
				break;
			default:
				return PAGE_ERROR;
			}
		}
		return PAGE_ADMIN_CRUD_FILM;
	}

	private Film buildFilm(HttpServletRequest req) {
		String id = req.getParameter(REQUEST_PARAM_FILM_ID);
		String filmName = req.getParameter(REQUEST_PARAM_FILM_NAME);
		String description = req.getParameter(REQUEST_PARAM_FILM_DESCRIPTION);
		String posterUrl = req.getParameter(REQUEST_PARAM_FILM_POSTER_URL);
		String[] genresId = req.getParameterValues(REQUEST_PARAM_FILM_GENRES);
		validateRequestParamNotNull(id, filmName, description, posterUrl);
		validateRequestParamNotNull(genresId);

		System.out.println(Arrays.toString(genresId));
		Film film = new Film();
		film.setId(getInt(id));
		film.setFilmName(filmName);
		film.setDescription(description);
		film.setPosterUrl(fixGoogleDriveUrl(posterUrl));

		Set<Genre> genres = new HashSet<>();
		for (String genreId : genresId) {
			genres.add(genreDao.read(getInt(genreId)));
		}
		film.setGenres(genres);
		return film;
	}
}

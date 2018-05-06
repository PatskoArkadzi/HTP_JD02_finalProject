package by.htp.cinema.web.action.impl;

import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.cinema.dao.GenreDao;
import by.htp.cinema.dao.impl.GenreDaoHibernateImpl;
import by.htp.cinema.domain.Genre;
import by.htp.cinema.web.action.BaseAction;

public class CrudGenreAction implements BaseAction {

	GenreDao genreDao = new GenreDaoHibernateImpl();

	@Override
	public String executeAction(HttpServletRequest req) {
		List<Genre> genres = genreDao.readAll();
		req.setAttribute(REQUEST_PARAM_GENRE_LIST, genres);
		if (isPost(req)) {
			String crudCommand = req.getParameter(REQUEST_PARAM_CRUD_COMMAND);
			validateRequestParamNotNull(crudCommand);
			Genre genre;

			switch (crudCommand) {
			case CRUD_OPERATION_NAME_CREATE:
				genre = buildGenre(req);
				genreDao.create(genre);
				break;
			case CRUD_OPERATION_NAME_READ:
				int roleId = getInt(req.getParameter(REQUEST_PARAM_GENRE_ID));
				genre = genreDao.read(roleId);
				req.setAttribute(REQUEST_PARAM_FOUND_GENRE, genre);
				break;
			case CRUD_OPERATION_NAME_UPDATE:
				genre = buildGenre(req);
				genreDao.update(genre);
				break;
			case CRUD_OPERATION_NAME_DELETE:
				genre = buildGenre(req);
				genreDao.delete(genre);
				break;
			default:
				return PAGE_ERROR;
			}
		}
		return PAGE_ADMIN_CRUD_GENRE;
	}

	private Genre buildGenre(HttpServletRequest req) {
		String id = req.getParameter(REQUEST_PARAM_GENRE_ID);
		String genreName = req.getParameter(REQUEST_PARAM_GENRE_NAME);
		validateRequestParamNotNull(id, genreName);

		Genre genre = new Genre();
		genre.setId(getInt(id));
		genre.setGenreName(genreName);
		return genre;
	}
}

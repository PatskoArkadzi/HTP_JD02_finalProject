package by.htp.cinema.web.action.impl;

import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.cinema.domain.Genre;
import by.htp.cinema.service.GenreService;
import by.htp.cinema.web.action.BaseAction;

public class CrudGenreAction implements BaseAction {
	GenreService genreService;

	public CrudGenreAction() {
	}

	public GenreService getGenreService() {
		return genreService;
	}

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

	@Override
	public String executeAction(HttpServletRequest req) {
		List<Genre> genres = genreService.getGenreList();
		req.setAttribute(REQUEST_PARAM_GENRE_LIST, genres);
		if (isPost(req)) {
			String crudCommand = req.getParameter(REQUEST_PARAM_CRUD_COMMAND);
			validateRequestParamNotNull(crudCommand);
			Genre genre;

			switch (crudCommand) {
			case CRUD_OPERATION_NAME_CREATE:
				genre = buildGenre(req);
				genreService.createGenre(genre);
				break;
			case CRUD_OPERATION_NAME_READ:
				String genreId = req.getParameter(REQUEST_PARAM_GENRE_ID);
				validateRequestParamNotNull(genreId);
				genre = genreService.readGenre(getInt(genreId));
				req.setAttribute(REQUEST_PARAM_FOUND_GENRE, genre);
				break;
			case CRUD_OPERATION_NAME_UPDATE:
				genre = buildGenre(req);
				genreService.updateGenre(genre);
				break;
			case CRUD_OPERATION_NAME_DELETE:
				genre = buildGenre(req);
				genreService.deleteGenre(genre);
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

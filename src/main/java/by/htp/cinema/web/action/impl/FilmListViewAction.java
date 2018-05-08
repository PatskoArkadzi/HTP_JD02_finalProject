package by.htp.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.cinema.domain.Film;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.web.action.BaseAction;
import static by.htp.cinema.web.util.ConstantDeclaration.*;

import java.util.List;

public class FilmListViewAction implements BaseAction {
	FilmService filmService;

	public FilmListViewAction() {
	}

	public FilmService getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}

	@Override
	public String executeAction(HttpServletRequest req) {
		List<Film> films = filmService.getFilmList();
		req.setAttribute(REQUEST_PARAM_FILM_LIST, films);

		return PAGE_USER_MAIN;
	}
}

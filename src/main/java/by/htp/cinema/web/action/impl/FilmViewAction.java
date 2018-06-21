package by.htp.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.service.FilmSessionService;
import by.htp.cinema.web.action.BaseAction;
import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FilmViewAction implements BaseAction {

	FilmService filmService;
	FilmSessionService filmSessionService;

	public FilmViewAction() {
	}

	public FilmService getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}

	public FilmSessionService getFilmSessionService() {
		return filmSessionService;
	}

	public void setFilmSessionService(FilmSessionService filmSessionService) {
		this.filmSessionService = filmSessionService;
	}

	@Override
	public String executeAction(HttpServletRequest req) {
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String filmId = req.getParameter(REQUEST_PARAM_FILM_ID);
		validateRequestParamNotNull(filmId);
		Film chosenFilm = filmService.readFilm(getInt(filmId));
		req.setAttribute(REQUEST_PARAM_USER_CHOSEN_FILM, chosenFilm);
		req.setAttribute(REQUEST_PARAM_CURRENT_DATE, dateFormat.format(new Date()));
		////////////////////
		List<FilmSession> chosenFilmFilmSessions = filmSessionService.getChosenFilmFilmSessionList(chosenFilm);
		
		if (isPost(req)) {
			String chosenDate = req.getParameter(REQUEST_PARAM_USER_CHOSEN_DATE);
			List<FilmSession> chosenFilmFilmSessions = filmSessionService.getChosenFilmFilmSessionList(chosenFilm);
			req.setAttribute(REQUEST_PARAM_CHOSEN_FILM_FILM_SESSIONS, chosenFilmFilmSessions);
		}*/

		return PAGE_USER_FILM_PAGE;
	}
}

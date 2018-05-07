package by.htp.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.dao.impl.FilmDaoHibernateImpl;
import by.htp.cinema.domain.Film;
import by.htp.cinema.web.action.BaseAction;
import static by.htp.cinema.web.util.ConstantDeclaration.*;

import java.util.List;

public class FilmListViewAction implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest req) {
		FilmDao filmDao = new FilmDaoHibernateImpl();
		List<Film> films = filmDao.readAll();
		req.setAttribute(REQUEST_PARAM_FILM_LIST, films);

		return PAGE_USER_MAIN;
	}
}

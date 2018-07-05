package by.htp.cinema.web.controllers.crudControllers;

import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Genre;
import by.htp.cinema.domain.Role;
import by.htp.cinema.domain.User;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.service.FilmSessionService;
import by.htp.cinema.service.GenreService;
import by.htp.cinema.service.RoleService;
import by.htp.cinema.service.UserService;

@Controller
@RequestMapping(value = "/newapp/admin/crud/session")
public class CrudFilmSessionController {

	@Autowired
	FilmService filmService;
	@Autowired
	FilmSessionService filmSessionService;

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {

		ModelAndView mav = new ModelAndView();
		mav.addObject(REQUEST_PARAM_FILM_LIST, filmService.getFilmList());
		mav.addObject(REQUEST_PARAM_FILM_SESSION_LIST, filmSessionService.getFilmSessionList());
		mav.addObject(REQUEST_PARAM_COMMAND_NAME_CRUD_FILM_SESSION, new FilmSession());
		mav.setViewName("springMvcPages/admin/crud_film_session");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_FILM_SESSION) FilmSession filmSession) {
		validateRequestParamNotNull(filmSession.getDate(), filmSession.getTime(), filmSession.getTicketPrice(),
				filmSession.getFilm());
		filmSessionService.createFilmSession(filmSession);
		return "redirect:/newapp/admin/crud/session/";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String read(@RequestParam String id) throws UnsupportedEncodingException {
		validateRequestParamIdnotNull(getInt(id));
		FilmSession foundFilmSession = filmSessionService.readFilmSession(getInt(id));
		return "{\"foundFilmSession\" : \"" + foundFilmSession + "\"}";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_FILM_SESSION) FilmSession filmSession) {
		validateRequestParamNotNull(filmSession.getId(), filmSession.getDate(), filmSession.getTime(),
				filmSession.getTicketPrice(), filmSession.getFilm());
		filmSessionService.updateFilmSession(filmSession);
		return "redirect:/newapp/admin/crud/session/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_FILM_SESSION) FilmSession filmSession) {
		validateRequestParamNotNull(filmSession.getId(), filmSession.getDate());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (new Date().before(format.parse(filmSession.getDate()))
					&& filmSessionService.isAnyTicketRelatedToFilmSession(filmSession.getId())) {
				return new ModelAndView("springMvcPages/error", REQUEST_PARAM_ERROR_MESSAGE,
						"Sorry. You can't delete filmSession");
			} else
				filmSessionService.deleteFilmSession(filmSession);
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return new ModelAndView("redirect:/newapp/admin/crud/session/");
	}
}

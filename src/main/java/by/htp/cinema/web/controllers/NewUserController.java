package by.htp.cinema.web.controllers;

import static by.htp.cinema.web.util.ConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.User;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.service.FilmSessionService;
import by.htp.cinema.service.ServiceManagerContext;
import by.htp.cinema.service.UserService;

@Controller
@RequestMapping(value = "/newapp/user")
public class NewUserController {

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest req) {
		FilmService filmService = (FilmService) ServiceManagerContext.getService(req, "filmService");
		List<Film> films = filmService.getFilmList();
		return new ModelAndView("user/main", REQUEST_PARAM_FILM_LIST, films);
	}

	@RequestMapping(value = "/film_page", method = RequestMethod.GET)
	public ModelAndView viewFilmPage(@RequestParam int film_id, HttpServletRequest req) {
		FilmService filmService = (FilmService) ServiceManagerContext.getService(req, "filmService");
		FilmSessionService filmSessionService = (FilmSessionService) ServiceManagerContext.getService(req,
				"filmSessionService");
		Film chosenFilm = filmService.readFilm(film_id);
		List<FilmSession> chosenFilmFilmSessions = filmSessionService.getChosenFilmFilmSessionList(chosenFilm);

		req.setAttribute(REQUEST_PARAM_USER_CHOSEN_FILM, chosenFilm);
		req.setAttribute(REQUEST_PARAM_CHOSEN_FILM_FILM_SESSIONS, chosenFilmFilmSessions);

		ModelAndView mav = new ModelAndView();
		mav.addObject(REQUEST_PARAM_USER_CHOSEN_FILM, chosenFilm);
		mav.addObject(REQUEST_PARAM_CHOSEN_FILM_FILM_SESSIONS, chosenFilmFilmSessions);
		mav.setViewName("user/film_page");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("user/login", SESSION_PARAM_CURRENT_USER, new User());
	}

	@RequestMapping(value = "/check_User", method = RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("user") User user, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		if (session.getAttribute(SESSION_PARAM_CURRENT_USER) != null) {
			mav.addObject(REQUEST_PARAM_ERROR_MESSAGE, "You are already logged in");
			mav.setViewName("redirect:/newapp/user/error");
			return mav;
		}
		UserService userService = (UserService) ServiceManagerContext.getService(req, "userService");
		User foundUser = userService.readUser(user.getLogin(), user.getPassword());

		if (foundUser != null) {
			session.setAttribute(SESSION_PARAM_CURRENT_USER, foundUser);
			session.setMaxInactiveInterval(60);
			mav.setViewName("redirect:/newapp/user/");
			return mav;
		} else {
			mav.addObject(REQUEST_PARAM_ERROR_MESSAGE, "Incorrect username or password");
			mav.setViewName("redirect:/newapp/user/error");
			return mav;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest req) {
		req.getSession().invalidate();
		req.setAttribute(SESSION_PARAM_CURRENT_USER, null);
		return new ModelAndView("redirect:/newapp/user/");
	}

	/*
	 * @RequestMapping(value = "/error", method = RequestMethod.GET) public
	 * ModelAndView error(@ModelAttribute(REQUEST_PARAM_ERROR_MESSAGE) String
	 * message, ModelAndView mav) { mav.addObject(REQUEST_PARAM_ERROR_MESSAGE,
	 * message); mav.setViewName("error"); return mav; }
	 */
	@RequestMapping(value = "/sign_up", method = RequestMethod.GET)
	public ModelAndView newUser(ModelMap model) {
		return new ModelAndView("user/signup", "command", new User());
	}

	@RequestMapping(value = "/checkLog", method = RequestMethod.GET)
	public @ResponseBody String checkLog(@RequestParam String jsonLogin, HttpServletRequest req) {
		JSONParser parser = new JSONParser();
		JSONObject obj;
		try {
			obj = (JSONObject) parser.parse(jsonLogin);
			String login = (String) obj.get("login");
			UserService userService = (UserService) ServiceManagerContext.getService(req, "userService");
			if (userService.readUser(login) != null) {
				return "This login is already taken";
			} else {
				return "This login is free";
			}
		} catch (ParseException e) {
			logger.error("jsonLogin parsing error");
		}
		return "error";
	}
}

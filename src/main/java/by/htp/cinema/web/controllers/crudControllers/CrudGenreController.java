package by.htp.cinema.web.controllers.crudControllers;

import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.htp.cinema.domain.Genre;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.service.GenreService;

@Controller
@RequestMapping(value = "/newapp/admin/crud/genre")
public class CrudGenreController {

	@Autowired
	GenreService genreService;
	@Autowired
	FilmService filmService;

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		List<Genre> genres = genreService.getGenreList();
		ModelAndView mav = new ModelAndView();
		mav.addObject(REQUEST_PARAM_GENRE_LIST, genres);
		mav.addObject(REQUEST_PARAM_COMMAND_NAME_CRUD_GENRE, new Genre());
		mav.setViewName("springMvcPages/admin/crud_genre");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_GENRE) Genre genre) {
		validateRequestParamNotNull(genre.getGenreName());
		genreService.createGenre(genre);
		return "redirect:/newapp/admin/crud/genre/";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String read(@RequestParam String id) throws UnsupportedEncodingException {
		validateRequestParamIdnotNull(getInt(id));
		Genre foundGenre = genreService.readGenre(getInt(id));
		return "{\"foundGenre\" : \"" + foundGenre + "\"}";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_GENRE) Genre genre) {
		validateRequestParamIdnotNull(genre.getId());
		validateRequestParamNotNull(genre.getGenreName());
		genreService.updateGenre(genre);
		return "redirect:/newapp/admin/crud/genre/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_GENRE) Genre genre) {
		ModelAndView mav = new ModelAndView();
		validateRequestParamIdnotNull(genre.getId());
		if (genreService.isAnyFilmContainGenre(genre.getId())) {
			mav.addObject(REQUEST_PARAM_ERROR_MESSAGE,
					"You can't delete genre.<br>Some films are marked by this genre");
			mav.setViewName("springMvcPages/error");
			return mav;
		}
		genreService.deleteGenre(genre);
		mav.setViewName("redirect:/newapp/admin/crud/genre/");
		return mav;
	}
}

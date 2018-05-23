package by.htp.cinema.web.controllers.crudControllers;

import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.htp.cinema.domain.Film;
import by.htp.cinema.domain.Genre;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.service.GenreService;

@Controller
@RequestMapping(value = "/newapp/admin/crud/film")
public class CrudFilmController {

	@Autowired
	FilmService filmService;
	@Autowired
	GenreService genreService;

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		List<Film> films = filmService.getFilmList();
		List<Genre> genres = genreService.getGenreList();

		ModelAndView mav = new ModelAndView();
		mav.addObject(REQUEST_PARAM_FILM_LIST, films);
		mav.addObject(REQUEST_PARAM_GENRE_LIST, genres);
		mav.addObject(REQUEST_PARAM_CRUD_FILM, new Film());
		mav.setViewName("admin/crud_film");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute(REQUEST_PARAM_CRUD_FILM) Film film, BindingResult result) {
		validateRequestParamNotNull(film.getId());
		validateRequestParamNotNull(film.getFilmName(), film.getDescription(), film.getPosterUrl());
		validateRequestParamNotNull(film.getGenres());
		filmService.createFilm(film);
		return "redirect:/newapp/admin/crud/film/";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Set.class, "genres", new CustomCollectionEditor(Set.class) {
			protected Object convertElement(Object element) {
				String genreId = (String) element;
				return genreId != null ? genreService.readGenre(getInt(genreId)) : null;
			}
		});
	}
}

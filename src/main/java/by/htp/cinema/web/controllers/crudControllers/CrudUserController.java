package by.htp.cinema.web.controllers.crudControllers;

import static by.htp.cinema.web.util.ConstantDeclaration.*;
import static by.htp.cinema.web.util.HttpRequestParamValidator.*;
import static by.htp.cinema.web.util.HttpRequestParamFormatter.*;

import java.io.UnsupportedEncodingException;
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
import by.htp.cinema.domain.Genre;
import by.htp.cinema.domain.Role;
import by.htp.cinema.domain.User;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.service.GenreService;
import by.htp.cinema.service.RoleService;
import by.htp.cinema.service.UserService;

@Controller
@RequestMapping(value = "/newapp/admin/crud/user")
public class CrudUserController {

	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		List<User> users = userService.getUserList();
		List<Role> roles = roleService.getRoleList();

		ModelAndView mav = new ModelAndView();
		mav.addObject(REQUEST_PARAM_USER_LIST, users);
		mav.addObject(REQUEST_PARAM_ROLE_LIST, roles);
		mav.addObject(REQUEST_PARAM_COMMAND_NAME_CRUD_USER, new User());
		mav.setViewName("admin/crud_user");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_USER) User user) {
		validateRequestParamNotNull(user.getLogin(), user.getEmail(), user.getPassword());
		validateRequestParamNotNull(user.getRole());
		userService.createUser(user);
		return "redirect:/newapp/admin/crud/user/";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String read(@RequestParam String id) throws UnsupportedEncodingException {
		validateRequestParamIdnotNull(getInt(id));
		User foundUser = userService.readUser(getInt(id));
		return "{\"foundUser\" : \"" + foundUser + "\"}";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_USER) User user) {
		validateRequestParamIdnotNull(user.getId());
		validateRequestParamNotNull(user.getLogin(), user.getEmail(), user.getPassword());
		validateRequestParamNotNull(user.getRole());
		userService.updateUser(user);
		return "redirect:/newapp/admin/crud/user/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_USER) User user) {
		validateRequestParamIdnotNull(user.getId());
		userService.deleteUser(user);
		return "redirect:/newapp/admin/crud/user/";
	}
}

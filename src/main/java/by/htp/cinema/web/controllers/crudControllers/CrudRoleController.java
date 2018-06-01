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
import by.htp.cinema.domain.Role;
import by.htp.cinema.service.RoleService;

@Controller
@RequestMapping(value = "/newapp/admin/crud/role")
public class CrudRoleController {

	@Autowired
	RoleService roleService;

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		List<Role> roles = roleService.getRoleList();
		ModelAndView mav = new ModelAndView();
		mav.addObject(REQUEST_PARAM_ROLE_LIST, roles);
		mav.addObject(REQUEST_PARAM_COMMAND_NAME_CRUD_ROLE, new Role());
		mav.setViewName("admin/crud_role");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_ROLE) Role role) {
		validateRequestParamNotNull(role.getRoleName());
		roleService.createRole(role);
		return "redirect:/newapp/admin/crud/role/";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String read(@RequestParam String id) throws UnsupportedEncodingException {
		validateRequestParamIdnotNull(getInt(id));
		Role foundRole = roleService.readRole(getInt(id));
		return "{\"foundRole\" : \"" + foundRole + "\"}";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_ROLE) Role role) {
		validateRequestParamIdnotNull(role.getId());
		validateRequestParamNotNull(role.getRoleName());
		roleService.updateRole(role);
		return "redirect:/newapp/admin/crud/role/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_ROLE) Role role) {
		ModelAndView mav = new ModelAndView();
		validateRequestParamIdnotNull(role.getId());
		if (roleService.isAnyFilmContainGenre(role.getId())) {
			mav.addObject(REQUEST_PARAM_ERROR_MESSAGE, "You can't delete role.<br>Some users are marked by this role");
			mav.setViewName("error");
			return mav;
		}
		roleService.deleteRole(role);
		mav.setViewName("redirect:/newapp/admin/crud/role/");
		return mav;
	}
}

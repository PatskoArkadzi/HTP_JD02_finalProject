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
import org.springframework.beans.factory.annotation.Qualifier;
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
import by.htp.cinema.domain.Ticket;
import by.htp.cinema.domain.TicketsOrder;
import by.htp.cinema.domain.User;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.service.FilmSessionService;
import by.htp.cinema.service.GenreService;
import by.htp.cinema.service.RoleService;
import by.htp.cinema.service.SeatService;
import by.htp.cinema.service.TicketService;
import by.htp.cinema.service.TicketsOrderService;
import by.htp.cinema.service.UserService;

@Controller
@RequestMapping(value = "/newapp/admin/crud/order")
public class CrudTicketsOrderController {

	@Autowired
	@Qualifier("ticketOrderService")
	TicketsOrderService ticketsOrderService;
	@Autowired
	UserService userService;

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(REQUEST_PARAM_FILM_TICKETS_ORDER_LIST, ticketsOrderService.getTicketsOrderList());
		mav.addObject(REQUEST_PARAM_USER_LIST, userService.getUserList());
		mav.addObject(REQUEST_PARAM_COMMAND_NAME_CRUD_TICKETS_ORDER, new TicketsOrder());
		mav.setViewName("springMvcPages/admin/crud_tickets_order");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_TICKETS_ORDER) TicketsOrder ticketsOrder) {
		validateRequestParamNotNull(ticketsOrder.getUser(), ticketsOrder.getIsPaid());
		ticketsOrderService.createTicketsOrder(ticketsOrder);
		return "redirect:/newapp/admin/crud/order/";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String read(@RequestParam String id) {
		validateRequestParamIdnotNull(getInt(id));
		System.out.println(id);
		TicketsOrder foundTicketsOrder = ticketsOrderService.readTicketsOrder(getInt(id));
		return "{\"foundTicketsOrder\" : \"" + foundTicketsOrder + "\"}";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_TICKETS_ORDER) TicketsOrder ticketsOrder) {
		validateRequestParamNotNull(ticketsOrder.getId(), ticketsOrder.getOrderNumber(), ticketsOrder.getUser(),
				ticketsOrder.getIsPaid());
		ticketsOrderService.updateTicketsOrder(ticketsOrder);
		return "redirect:/newapp/admin/crud/order/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_TICKETS_ORDER) TicketsOrder ticketsOrder) {
		validateRequestParamIdnotNull(ticketsOrder.getId());
		ticketsOrderService.deleteTicketsOrder(ticketsOrder);
		return "redirect:/newapp/admin/crud/order/";
	}
}

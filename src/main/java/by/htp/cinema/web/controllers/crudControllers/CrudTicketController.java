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
@RequestMapping(value = "/newapp/admin/crud/ticket")
public class CrudTicketController {

	@Autowired
	TicketService ticketService;
	@Autowired
	FilmSessionService filmSessionService;
	@Autowired
	SeatService seatService;
	@Autowired
	@Qualifier("ticketOrderService")
	TicketsOrderService ticketsOrderService;

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(REQUEST_PARAM_FILM_TICKET_LIST, ticketService.getTicketList());
		mav.addObject(REQUEST_PARAM_FILM_SESSION_LIST, filmSessionService.getFilmSessionList());
		mav.addObject(REQUEST_PARAM_SEAT_LIST, seatService.getSeatList());
		mav.addObject(REQUEST_PARAM_FILM_TICKETS_ORDER_LIST, ticketsOrderService.getTicketsOrderList());
		mav.addObject(REQUEST_PARAM_COMMAND_NAME_CRUD_TICKET, new Ticket());
		mav.setViewName("springMvcPages/admin/crud_ticket");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_TICKET) Ticket ticket) {
		validateRequestParamNotNull(ticket.getFilmSession(), ticket.getSeat(), ticket.getOrder());
		ticketService.createTicket(ticket);
		return "redirect:/newapp/admin/crud/ticket/";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String read(@RequestParam String id) throws UnsupportedEncodingException {
		validateRequestParamIdnotNull(getInt(id));
		Ticket foundTicket = ticketService.readTicket(getInt(id));
		return "{\"foundTicket\" : \"" + foundTicket + "\"}";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_TICKET) Ticket ticket) {
//		System.out.println(ticket.getId());
//		System.out.println(ticket.getFilmSession());
//		System.out.println(ticket.getSeat());
//		System.out.println(ticket.getOrder());
		validateRequestParamNotNull(ticket.getId(), ticket.getFilmSession(), ticket.getSeat(), ticket.getOrder());
		ticketService.updateTicket(ticket);
		return "redirect:/newapp/admin/crud/ticket/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute(REQUEST_PARAM_COMMAND_NAME_CRUD_TICKET) Ticket ticket) {
		validateRequestParamIdnotNull(ticket.getId());
		ticketService.deleteTicket(ticket);
		return "redirect:/newapp/admin/crud/ticket/";
	}

}

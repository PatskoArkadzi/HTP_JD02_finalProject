package by.htp.cinema.SpringConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.dao.FilmSessionDao;
import by.htp.cinema.dao.GenreDao;
import by.htp.cinema.dao.RoleDao;
import by.htp.cinema.dao.SeatDao;
import by.htp.cinema.dao.TicketDao;
import by.htp.cinema.dao.TicketsOrderDao;
import by.htp.cinema.dao.UserDao;
import by.htp.cinema.dao.impl.FilmDaoHibernateImpl;
import by.htp.cinema.dao.impl.FilmSessionDaoHibernateImpl;
import by.htp.cinema.dao.impl.GenreDaoHibernateImpl;
import by.htp.cinema.dao.impl.RoleDaoHibernateImpl;
import by.htp.cinema.dao.impl.SeatDaoHibernateImpl;
import by.htp.cinema.dao.impl.TicketDaoHibernateImpl;
import by.htp.cinema.dao.impl.TicketsOrderDaoHibernateImpl;
import by.htp.cinema.dao.impl.UserDaoHibernateImpl;
import by.htp.cinema.service.FilmService;
import by.htp.cinema.service.FilmSessionService;
import by.htp.cinema.service.GenreService;
import by.htp.cinema.service.RoleService;
import by.htp.cinema.service.SeatService;
import by.htp.cinema.service.TicketService;
import by.htp.cinema.service.TicketsOrderService;
import by.htp.cinema.service.UserService;
import by.htp.cinema.service.impl.CustomUserDetailsServiceImpl;
import by.htp.cinema.service.impl.FilmServiceImpl;
import by.htp.cinema.service.impl.FilmSessionServiceImpl;
import by.htp.cinema.service.impl.GenreServiceImpl;
import by.htp.cinema.service.impl.RoleServiceImpl;
import by.htp.cinema.service.impl.SeatServiceImpl;
import by.htp.cinema.service.impl.TicketServiceImpl;
import by.htp.cinema.service.impl.TicketsOrderServiceImpl;
import by.htp.cinema.service.impl.UserServiceImpl;

@Configuration
public class SpringServiceConfig {
	{
		System.out.println("SpringServiceConfig");
	}

	@Bean
	protected UserDetailsService userDetailsService(UserDao userDao) {
		return new CustomUserDetailsServiceImpl(userDao);
	}

	@Bean
	FilmService filmService(FilmDao filmDao) {
		return new FilmServiceImpl(filmDao);
	}

	@Bean
	FilmSessionService filmSessionService(FilmSessionDao filmSessionDao) {
		return new FilmSessionServiceImpl(filmSessionDao);
	}

	@Bean
	GenreService genreService(GenreDao genreDao, FilmDao filmDao) {
		return new GenreServiceImpl(genreDao, filmDao);
	}

	@Bean
	RoleService roleService(RoleDao roleDao, UserDao userDao) {
		return new RoleServiceImpl(roleDao, userDao);
	}

	@Bean
	SeatService seatService(SeatDao seatDao, TicketsOrderDao ticketsOrderDao) {
		return new SeatServiceImpl(seatDao, ticketsOrderDao);
	}

	@Bean
	TicketService ticketService(TicketDao ticketDao) {
		return new TicketServiceImpl(ticketDao);
	}

	@Bean
	TicketsOrderService ticketOrderService(TicketsOrderDao ticketsOrderDao) {
		return new TicketsOrderServiceImpl(ticketsOrderDao);
	}

	@Bean
	UserService userService(UserDao userDao) {
		return new UserServiceImpl(userDao);
	}
}

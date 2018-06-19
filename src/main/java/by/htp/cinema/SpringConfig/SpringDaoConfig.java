package by.htp.cinema.SpringConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
import by.htp.cinema.service.impl.FilmServiceImpl;

@Configuration
public class SpringDaoConfig {
	{
		System.out.println("SpringDaoConfig");
	}

	@Bean
	FilmDao filmDao() {
		return new FilmDaoHibernateImpl();
	}

	@Bean
	FilmSessionDao filmSessionDao() {
		return new FilmSessionDaoHibernateImpl();
	}

	@Bean
	GenreDao genreDao() {
		return new GenreDaoHibernateImpl();
	}

	@Bean
	RoleDao roleDao() {
		return new RoleDaoHibernateImpl();
	}

	@Bean
	SeatDao seatDao() {
		return new SeatDaoHibernateImpl();
	}

	@Bean
	TicketDao ticketDao() {
		return new TicketDaoHibernateImpl();
	}

	@Bean
	TicketsOrderDao ticketsOrderDao() {
		return new TicketsOrderDaoHibernateImpl();
	}

	@Bean
	UserDao userDao() {
		return new UserDaoHibernateImpl();
	}

}

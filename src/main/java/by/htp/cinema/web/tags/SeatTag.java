package by.htp.cinema.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;

import by.htp.cinema.dao.impl.SeatDaoHibernateImpl;
import by.htp.cinema.dao.impl.TicketsOrderDaoHibernateImpl;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;
import by.htp.cinema.domain.TicketsOrder;
import by.htp.cinema.service.SeatService;
import by.htp.cinema.service.TicketsOrderService;
import by.htp.cinema.service.impl.SeatServiceImpl;
import by.htp.cinema.service.impl.TicketsOrderServiceImpl;

public class SeatTag extends TagSupport {

	// @Autowired
	// private SeatService seatService;
	// @Autowired
	// private TicketsOrderService ticketsOrderService;

	private int row;
	private int column;
	private FilmSession filmSession;
	private boolean isStateRequired;

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setFilmSession(FilmSession filmSession) {
		this.filmSession = filmSession;
	}

	public void setIsStateRequired(boolean isStateRequired) {
		this.isStateRequired = isStateRequired;
	}

	@Override
	public int doStartTag() throws JspException {
		// SeatService seatService = new SeatServiceImpl();
		// Seat seat = seatService.readSeat(row, column);
		Seat seat = new SeatDaoHibernateImpl().read(row, column);
		if (seat != null && isStateRequired) {
			// TicketsOrderService ticketsOrderService = new TicketsOrderServiceImpl();
			// TicketsOrder ticketsOrder =
			// ticketsOrderService.readOrderWhereSeatPresent(seat, filmSession);
			TicketsOrder ticketsOrder = new TicketsOrderDaoHibernateImpl().read(seat, filmSession);
			if (ticketsOrder == null)
				seat.setState(Seat.State.FREE);
			else if (ticketsOrder.isPaid()) {
				seat.setState(Seat.State.OCCUPIED);
			} else {
				seat.setState(Seat.State.BOOKED);
			}
		}
		pageContext.setAttribute("seat", seat);
		return SKIP_BODY;
	}
}

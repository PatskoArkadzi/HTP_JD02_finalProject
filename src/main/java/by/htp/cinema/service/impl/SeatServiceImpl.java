package by.htp.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.cinema.dao.SeatDao;
import by.htp.cinema.dao.TicketsOrderDao;
import by.htp.cinema.domain.FilmSession;
import by.htp.cinema.domain.Seat;
import by.htp.cinema.domain.TicketsOrder;
import by.htp.cinema.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatDao seatDao;

	@Autowired
	TicketsOrderDao ticketsOrderDao;

	public SeatServiceImpl() {
	}

	public SeatDao getSeatDao() {
		return seatDao;
	}

	public void setSeatDao(SeatDao seatDao) {
		this.seatDao = seatDao;
	}

	public TicketsOrderDao getTicketsOrderDao() {
		return ticketsOrderDao;
	}

	public void setTicketsOrderDao(TicketsOrderDao ticketsOrderDao) {
		this.ticketsOrderDao = ticketsOrderDao;
	}

	@Override
	public List<Seat> getSeatList() {
		return seatDao.readAll("id");
	}

	@Override
	public void createSeat(Seat seat) {
		seatDao.create(seat);
	}

	@Override
	public Seat readSeat(int id) {
		return seatDao.read(id);
	}

	@Override
	public Seat readSeat(int row, int number) {
		return seatDao.read(row, number);
	}

	@Override
	public void updateSeat(Seat seat) {
		seatDao.update(seat);
	}

	@Override
	public void deleteSeat(Seat seat) {
		seatDao.delete(seat);
	}

	@Override
	public Seat setSeatState(Seat seat, FilmSession filmSession) {
		TicketsOrder ticketsOrder = ticketsOrderDao.read(seat, filmSession);
		if (ticketsOrder == null)
			seat.setState(Seat.State.FREE);
		else if (ticketsOrder.isPaid())
			seat.setState(Seat.State.OCCUPIED);
		else
			seat.setState(Seat.State.BOOKED);
		return seat;
	}
}

package by.htp.cinema.service.impl;

import java.util.List;

import by.htp.cinema.dao.SeatDao;
import by.htp.cinema.domain.Seat;
import by.htp.cinema.service.SeatService;

public class SeatServiceImpl implements SeatService {

	SeatDao seatDao;

	public SeatServiceImpl() {
	}

	public SeatDao getSeatDao() {
		return seatDao;
	}

	public void setSeatDao(SeatDao seatDao) {
		this.seatDao = seatDao;
	}

	@Override
	public List<Seat> getSeatList() {
		return seatDao.readAll();
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
	public void updateSeat(Seat seat) {
		seatDao.update(seat);
	}

	@Override
	public void deleteSeat(Seat seat) {
		seatDao.delete(seat);
	}
}
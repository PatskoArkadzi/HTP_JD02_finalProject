package by.htp.cinema.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

	private static final long serialVersionUID = -7308318330045764024L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "price")
	private int price;

	@ManyToOne
	@JoinColumn(name = "session_id")
	private FilmSession filmSession;

	@ManyToOne
	@JoinColumn(name = "seat_id")
	private Seat seat;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Ticket() {
		super();
	}

	public Ticket(int id, int price, FilmSession filmSession, Seat seat, Order order) {
		super();
		this.id = id;
		this.price = price;
		this.filmSession = filmSession;
		this.seat = seat;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public FilmSession getFilmSession() {
		return filmSession;
	}

	public void setFilmSession(FilmSession filmSession) {
		this.filmSession = filmSession;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmSession == null) ? 0 : filmSession.hashCode());
		result = prime * result + id;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + price;
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (filmSession == null) {
			if (other.filmSession != null)
				return false;
		} else if (!filmSession.equals(other.filmSession))
			return false;
		if (id != other.id)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (price != other.price)
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", price=" + price + ", filmSession=" + filmSession + ", seat=" + seat + ", order="
				+ order + "]";
	}

}

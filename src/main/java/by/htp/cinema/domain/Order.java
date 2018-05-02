package by.htp.cinema.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -1852653197354547323L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "orderNumber")
	private int orderNumber;

	@Column(name = "isPaid")
	private boolean isPaid;

	@OneToMany(mappedBy = "order")
	private Set<Ticket> tickets;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(mappedBy = "orders")
	private Set<FilmSession> filmSessions;

	@ManyToMany(mappedBy = "orders")
	private Set<Seat> seats;

	public Order() {
		super();
	}

	public Order(int id, int orderNumber, boolean isPaid, Set<Ticket> tickets, User user, Set<FilmSession> filmSessions,
			Set<Seat> seats) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.isPaid = isPaid;
		this.tickets = tickets;
		this.user = user;
		this.filmSessions = filmSessions;
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<FilmSession> getFilmSessions() {
		return filmSessions;
	}

	public void setFilmSessions(Set<FilmSession> filmSessions) {
		this.filmSessions = filmSessions;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmSessions == null) ? 0 : filmSessions.hashCode());
		result = prime * result + id;
		result = prime * result + (isPaid ? 1231 : 1237);
		result = prime * result + orderNumber;
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (filmSessions == null) {
			if (other.filmSessions != null)
				return false;
		} else if (!filmSessions.equals(other.filmSessions))
			return false;
		if (id != other.id)
			return false;
		if (isPaid != other.isPaid)
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", isPaid=" + isPaid + ", tickets=" + tickets
				+ ", user=" + user + ", filmSessions=" + filmSessions + ", seats=" + seats + "]";
	}

}

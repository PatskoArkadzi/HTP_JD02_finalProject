package by.htp.cinema.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat implements Serializable {

	private static final long serialVersionUID = -8046225975482720446L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "row")
	int row;

	@Column(name = "number")
	int number;

	@OneToMany(mappedBy = "seat")
	private Set<Ticket> tickets;

	@ManyToMany()
	private Set<Order> orders;

	@ManyToMany()
	private Set<FilmSession> filmSessions;

	public Seat() {
		super();
	}

	public Seat(int id, int row, int number, Set<Ticket> tickets, Set<Order> orders, Set<FilmSession> filmSessions) {
		super();
		this.id = id;
		this.row = row;
		this.number = number;
		this.tickets = tickets;
		this.orders = orders;
		this.filmSessions = filmSessions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<FilmSession> getFilmSessions() {
		return filmSessions;
	}

	public void setFilmSessions(Set<FilmSession> filmSessions) {
		this.filmSessions = filmSessions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmSessions == null) ? 0 : filmSessions.hashCode());
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + row;
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
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
		Seat other = (Seat) obj;
		if (filmSessions == null) {
			if (other.filmSessions != null)
				return false;
		} else if (!filmSessions.equals(other.filmSessions))
			return false;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (row != other.row)
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", row=" + row + ", number=" + number + ", tickets=" + tickets + ", orders=" + orders
				+ ", filmSessions=" + filmSessions + "]";
	}

}

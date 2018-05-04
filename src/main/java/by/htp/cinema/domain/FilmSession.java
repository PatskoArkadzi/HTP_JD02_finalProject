package by.htp.cinema.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
public class FilmSession implements Serializable {

	private static final long serialVersionUID = -6832669965931418330L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "date")
	private String date;

	@Column(name = "time")
	private String time;

	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;

	@OneToMany(mappedBy = "filmSession")
	private Set<Ticket> tickets;

	@ManyToMany()
	@JoinTable(name = "tickets", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<TicketsOrder> ticketsOrders;

	@ManyToMany()
	@JoinTable(name = "tickets", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "seat_id"))
	private Set<Seat> seats;

	public FilmSession() {
		super();
	}

	public FilmSession(int id, String date, String time, Set<Ticket> tickets, Film film, Set<TicketsOrder> orders,
			Set<Seat> seats) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.tickets = tickets;
		this.film = film;
		this.ticketsOrders = orders;
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Set<TicketsOrder> getOrders() {
		return ticketsOrders;
	}

	public void setOrders(Set<TicketsOrder> orders) {
		this.ticketsOrders = orders;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + id;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		FilmSession other = (FilmSession) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (id != other.id)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FilmSession [id=" + id + ", date=" + date + ", time=" + time + ", film=" + film.getFilmName() + "]";
	}

}

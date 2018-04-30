package by.htp.cinema.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

	private static final long serialVersionUID = -7308318330045764024L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "session_id")
	private int session_id;
	@Column(name = "seat_id")
	private int seat_id;
	@Column(name = "order_id")
	private int order_id;
	@Column(name = "price")
	private int price;

	public Ticket() {
		super();
	}

	public Ticket(int id, int session_id, int seat_id, int order_id, int price) {
		super();
		this.id = id;
		this.session_id = session_id;
		this.seat_id = seat_id;
		this.order_id = order_id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSession_id() {
		return session_id;
	}

	public void setSession_id(int session_id) {
		this.session_id = session_id;
	}

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + order_id;
		result = prime * result + price;
		result = prime * result + seat_id;
		result = prime * result + session_id;
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
		if (id != other.id)
			return false;
		if (order_id != other.order_id)
			return false;
		if (price != other.price)
			return false;
		if (seat_id != other.seat_id)
			return false;
		if (session_id != other.session_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", session_id=" + session_id + ", seat_id=" + seat_id + ", order_id=" + order_id
				+ ", price=" + price + "]";
	}

}

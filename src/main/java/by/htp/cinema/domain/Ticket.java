package by.htp.cinema.domain;

public class Ticket extends Entity{

	private static final long serialVersionUID = -7308318330045764024L;
	private int session_id;
	private int seat_id;
	private int price;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int id, int session_id, int seat_id, int price) {
		super(id);
		this.session_id = session_id;
		this.seat_id = seat_id;
		this.price = price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + price;
		result = prime * result + seat_id;
		result = prime * result + session_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (getId() != other.getId()) {
			return false;
		}
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
		return "Ticket [session_id=" + session_id + ", seat_id=" + seat_id + ", price=" + price + "]";
	}
	
	

}

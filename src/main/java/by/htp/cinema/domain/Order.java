package by.htp.cinema.domain;

public class Order extends Entity {

	private static final long serialVersionUID = -1852653197354547323L;
	private int orderNumber;
	private int userId;
	private int ticket_id;
	private boolean isPaid;

	public Order() {
		super();
	}

	public Order(int id, int orderNumber, int userId, int ticket_id, boolean isPaid) {
		super(id);
		this.orderNumber = orderNumber;
		this.userId = userId;
		this.ticket_id = ticket_id;
		this.isPaid = isPaid;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + (isPaid ? 1231 : 1237);
		result = prime * result + orderNumber;
		result = prime * result + ticket_id;
		result = prime * result + userId;
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
		Order other = (Order) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (isPaid != other.isPaid)
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (ticket_id != other.ticket_id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", userId=" + userId + ", ticket_id=" + ticket_id + ", isPaid="
				+ isPaid + "]";
	}

}

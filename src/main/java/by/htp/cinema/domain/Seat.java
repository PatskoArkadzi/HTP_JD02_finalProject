package by.htp.cinema.domain;

public class Seat extends Entity {

	private static final long serialVersionUID = -8046225975482720446L;
	int row;
	int number;

	public Seat() {
		super();
	}

	public Seat(int id, int row, int number) {
		super(id);
		this.row = row;
		this.number = number;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + number;
		result = prime * result + row;
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
		Seat other = (Seat) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (number != other.number)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seat [row=" + row + ", number=" + number + "]";
	}

}

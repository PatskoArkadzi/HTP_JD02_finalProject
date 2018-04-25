package by.htp.cinema.domain;

public class FilmSession extends Entity {

	private static final long serialVersionUID = -6832669965931418330L;
	private int film_id;
	private String date;
	private String time;

	public FilmSession() {
		super();
	}

	public FilmSession(int id, int film_id, String date, String time) {
		super(id);
		this.film_id = film_id;
		this.date = date;
		this.time = time;
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + film_id;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		FilmSession other = (FilmSession) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (film_id != other.film_id)
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
		return "FilmSession [film_id=" + film_id + ", date=" + date + ", time=" + time + "]";
	}

}

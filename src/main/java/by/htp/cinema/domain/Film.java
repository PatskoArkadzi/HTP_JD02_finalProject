package by.htp.cinema.domain;


public class Film extends Entity {

	private static final long serialVersionUID = -241014190878434680L;
	private String filmName;
	private String genre;
	private String description;

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Film(int id, String filmName, String genre, String description) {
		super(id);
		this.filmName = filmName;
		this.genre = genre;
		this.description = description;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * getId();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
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
		Film other = (Film) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (filmName == null) {
			if (other.filmName != null)
				return false;
		} else if (!filmName.equals(other.filmName))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [\nfilmName=" + filmName + "\ngenre=" + genre + "\ndescription=" + description + "\n]\n";
	}

}

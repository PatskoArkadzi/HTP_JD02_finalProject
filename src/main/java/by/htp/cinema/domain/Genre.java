package by.htp.cinema.domain;

import java.util.Set;


public class Genre extends BaseEntity {

	private static final long serialVersionUID = 8570084626243097559L;
	private int id;
	private String genreName;
	private Set<Film> films;

	public Genre() {
		super();
	}

	public Genre(int id, String genreName, Set<Film> films) {
		super();
		this.id = id;
		this.genreName = genreName;
		this.films = films;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((films == null) ? 0 : films.hashCode());
		result = prime * result + ((genreName == null) ? 0 : genreName.hashCode());
		result = prime * result + id;
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
		Genre other = (Genre) obj;
		if (films == null) {
			if (other.films != null)
				return false;
		} else if (!films.equals(other.films))
			return false;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreName=" + genreName + ", films=" + films + "]";
	}

}
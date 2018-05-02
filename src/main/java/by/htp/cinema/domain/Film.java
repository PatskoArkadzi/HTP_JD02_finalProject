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
@Table(name = "films")
public class Film implements Serializable {

	private static final long serialVersionUID = -241014190878434680L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "filmName")
	private String filmName;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "sessions")
	private Set<FilmSession> filmSessions;

	@ManyToMany()
	private Set<Genre> genres;

	public Film() {
		super();
	}

	public Film(int id, String filmName, String description, Set<FilmSession> filmSessions, Set<Genre> genres) {
		super();
		this.id = id;
		this.filmName = filmName;
		this.description = description;
		this.filmSessions = filmSessions;
		this.genres = genres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<FilmSession> getFilmSessions() {
		return filmSessions;
	}

	public void setFilmSessions(Set<FilmSession> filmSessions) {
		this.filmSessions = filmSessions;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
		result = prime * result + ((filmSessions == null) ? 0 : filmSessions.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
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
		Film other = (Film) obj;
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
		if (filmSessions == null) {
			if (other.filmSessions != null)
				return false;
		} else if (!filmSessions.equals(other.filmSessions))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", filmName=" + filmName + ", description=" + description + ", filmSessions="
				+ filmSessions + ", genres=" + genres + "]";
	}

}

package by.htp.cinema.service;

import java.util.List;

import by.htp.cinema.domain.Genre;

public interface GenreService extends Service {

	List<Genre> getGenreList();

	void createGenre(Genre genre);

	Genre readGenre(int id);

	void updateGenre(Genre genre);

	void deleteGenre(Genre genre);
}

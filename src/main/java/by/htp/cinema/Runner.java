package by.htp.cinema;

import java.util.List;

import by.htp.cinema.dao.FilmDao;
import by.htp.cinema.dao.impl.FilmDaoHibernateImpl;
import by.htp.cinema.domain.Film;

public class Runner {

	public static void main(String[] args) {
		FilmDao filmDao = new FilmDaoHibernateImpl();
		/*
		Film filmEng=new Film(1,"aaa","bbb","ccc");
		Film filmRus=new Film(1,"ааа","ббб","ввв");
		
		filmDao.create(filmEng);		
		filmDao.create(filmRus);		
		
		List<Film> films = filmDao.readAll();

		for (Film f : films)
			System.out.println(f);*/
		Film testFilm=new Film(1,"aaa","bbb","ccc");
		filmDao.create(testFilm);
		System.out.println(filmDao.read(1));
		testFilm.setFilmName("111");
		filmDao.update(testFilm);
		System.out.println(filmDao.read(1));
		
	}

}

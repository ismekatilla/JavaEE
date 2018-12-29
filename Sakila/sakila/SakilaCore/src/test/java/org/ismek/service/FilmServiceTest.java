package org.ismek.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Film;
import org.junit.Test;

public class FilmServiceTest {
	
	private static Logger logger = LogManager.getLogger(FilmServiceTest.class);

	@Test
	public void findAllFilm() {
		FilmService filmService = new FilmService();
		List<Film> filmList = filmService.findAllFilm();
		for (Film film : filmList) {
			System.out.println(film.getLanguage().getName());
		}
	}
}
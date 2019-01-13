package org.ismek.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Film;
import org.ismek.domain.Language;
import org.junit.Ignore;
import org.junit.Test;

//@Ignore
public class FilmServiceTest {
	
	private static Logger logger = LogManager.getLogger(FilmServiceTest.class);

FilmService filmService = new FilmService();
	
	@Test
	public void findAllFilmTest() {
		List<Film> filmList = filmService.findAll();
		for (Film film : filmList) {
			System.out.println(film.getTitle() + " - " + film.getLanguage().getName());
		}
	}
	
	@Test
	public void saveFilmTest() {
		
		Film film = new Film();
		film.setTitle("Yabancı Film");
		
		Film savedFilm = filmService.save(film);
		System.out.println(savedFilm.getId());
	}
	
	@Test
	public void saveFilmByIdTest() {
		
		Film film = filmService.findById(3L);
		film.setTitle("Yabancı Film");
		
		Film savedFilm = filmService.save(film);
		System.out.println(savedFilm.getId());
	}
	
	@Test
	public void findById() {
		Film film = filmService.findById(2L);
		System.out.println(film.getTitle());
	}
	
	@Test
	public void saveWithLanguage() {
		
		Language language = new Language();
		language.setName("YENİ DİL");
		language.setLastUpdate(new Date());
		
		Film film = new Film();
		film.setTitle("TİTLE");
		film.setLanguage(language);
		
		Film savedFilm = filmService.save(film);
		System.out.println(savedFilm.getTitle());
	}
	
	@Test
	public void saveWithLanguage2() {
		LanguageService languageService = new LanguageService();
		Language language = languageService.findByIdEager(1L);
		
		Film film = new Film();
		film.setTitle("TİTLE");
		film.setLanguage(language);
		
		Film savedFilm = filmService.save(film);
		System.out.println(savedFilm.getTitle());
	}
	
	@Test
	public void findAllFilmByLanguageName() {
		List<Film> filmList = filmService.findAllFilmByLanguageName("English");
		for (Film film : filmList) {
			System.out.println(film.getTitle() + " - " + film.getLanguage().getName());
		}
	}
}
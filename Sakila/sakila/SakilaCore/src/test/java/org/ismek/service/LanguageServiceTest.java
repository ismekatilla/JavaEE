package org.ismek.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Film;
import org.ismek.domain.Language;
import org.junit.Test;

public class LanguageServiceTest {
	
	private static Logger logger = LogManager.getLogger(LanguageServiceTest.class);

	@Test
	public void findAllLanguage() {
		LanguageService languageService = new LanguageService();
		List<Language> languageList = languageService.findAllLanguage();
		for (Language language : languageList) {
			Set<Film> filmSet = language.getFilmSet();
			for (Film film : filmSet) {
				System.out.println(language.getName() + " - " + film.getTitle());
			}
		}
	}
	
	@Test
	public void saveLanguage() {
		LanguageService languageService = new LanguageService();
		
		Film film = new Film();
		film.setTitle("TEST FİLMİ");
		film.setDescription("TEST ");
		Set<Film> filmSet = new HashSet<Film>();
		filmSet.add(film);
		
		Language language = new Language();
		language.setName("Test");
		language.setLastUpdate(new Date());
		language.setFilmSet(filmSet);
		
		Language savedLanguage = languageService.saveLanguage(language);
		System.out.println(savedLanguage.getId());
	}
}
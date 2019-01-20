package org.ismek.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Film;
import org.ismek.domain.Language;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class LanguageServiceTest {

	private static Logger logger = LogManager.getLogger(LanguageServiceTest.class);

	LanguageService languageService = new LanguageService();

	@Test
	public void findAllLanguageTest() {
		List<Language> languageList = languageService.findAll();
		for (Language language : languageList) {
			System.out.println(language.getName());
		}
	}

	@Test
	public void saveLanguageTest() {

		Language language = new Language();
		language.setName("Yabancı Dil");
		language.setLastUpdate(new Date());

		LanguageService languageService = new LanguageService();
		Language savedLanguage = languageService.save(language);
		System.out.println(savedLanguage.getId());
	}

	@Test
	public void saveLanguageByIdTest() {

		LanguageService languageService = new LanguageService();

		Language language = languageService.findById(3L);
		language.setName("Yabancı Dil");

		Language savedLanguage = languageService.save(language);
		System.out.println(savedLanguage.getId());
	}

	@Test
	public void findById() {
		LanguageService languageService = new LanguageService();
		Language language = languageService.findById(1L);
		System.out.println(language.getName());
		
		Set<Film> filmSet = language.getFilmSet();
		for (Film film : filmSet) {
			System.out.println(film.getTitle());
		}
	}
}
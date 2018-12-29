package org.ismek.service;

import java.util.List;

import org.ismek.dao.LanguageDao;
import org.ismek.domain.Language;

public class LanguageService {

	public List<Language> findAllLanguage() {
		LanguageDao languageDao = new LanguageDao();
		return languageDao.findAll();
	}
	
	public Language saveLanguage(Language language) {
		LanguageDao languageDao = new LanguageDao();
		return languageDao.save(language);
	}
}
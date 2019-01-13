package org.ismek.service;

import org.ismek.dao.LanguageDao;
import org.ismek.domain.Language;

public class LanguageService extends BaseService<Language> {

	public LanguageService() {
		super(Language.class);
	}

	public Language findByIdEager(Long languageId) {
		LanguageDao languageDao = new LanguageDao();
		return languageDao.findByIdEager(languageId);
	}
}
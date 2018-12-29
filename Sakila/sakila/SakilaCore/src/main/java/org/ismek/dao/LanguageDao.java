package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Language;

public class LanguageDao extends BaseDao<Language> {
	
	private static Logger logger = LogManager.getLogger(LanguageDao.class);
	
	public LanguageDao() {
		super(Language.class);
	}
}
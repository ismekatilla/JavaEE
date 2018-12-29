package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Film;

public class FilmDao extends BaseDao<Film> {
	
	private static Logger logger = LogManager.getLogger(FilmDao.class);
	
	public FilmDao() {
		super(Film.class);
	}
}
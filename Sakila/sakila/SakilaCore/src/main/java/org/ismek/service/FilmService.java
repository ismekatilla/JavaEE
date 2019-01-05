package org.ismek.service;

import java.util.List;

import org.ismek.dao.FilmDao;
import org.ismek.domain.Film;

public class FilmService extends BaseService<Film> {

	public FilmService() {
		super(Film.class);
	}
	
	public List<Film> findAllFilmByLanguageName(String languageName) {
		FilmDao filmDao = new FilmDao();
		return filmDao.findAllFilmByLanguageName(languageName);
	}
}
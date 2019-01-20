package org.ismek.service;

import java.util.List;

import org.ismek.dao.FilmDao;
import org.ismek.domain.Film;
import org.ismek.dto.FilmRatingDto;

public class FilmService extends BaseService<Film> {

	public FilmService() {
		super(Film.class);
	}
	
	public List<Film> findAllFilmByLanguageName(String languageName) {
		FilmDao filmDao = new FilmDao();
		return filmDao.findAllFilmByLanguageName(languageName);
	}
	
	public List<FilmRatingDto> groupByRating() {
		FilmDao filmDao = new FilmDao();
		return filmDao.groupByRating();
	}
	
	public List<FilmRatingDto> groupByRatingNative() {
		FilmDao filmDao = new FilmDao();
		return filmDao.groupByRatingNative();
	}
}
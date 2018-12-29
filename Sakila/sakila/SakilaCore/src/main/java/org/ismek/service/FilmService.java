package org.ismek.service;

import java.util.List;

import org.ismek.dao.FilmDao;
import org.ismek.domain.Film;

public class FilmService {

	public List<Film> findAllFilm() {
		FilmDao filmDao = new FilmDao();
		return filmDao.findAll();
	}
	
	public Film saveFilm(Film film) {
		FilmDao filmDao = new FilmDao();
		return filmDao.save(film);
	}
}
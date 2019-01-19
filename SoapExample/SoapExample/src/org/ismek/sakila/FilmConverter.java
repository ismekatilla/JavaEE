package org.ismek.sakila;

import org.ismek.domain.Film;
import org.ismek.sakila.dto.FilmDto;

public class FilmConverter {

	public FilmDto convertToFilmDto(Film film) {
		FilmDto filmDto = new FilmDto();
		filmDto.setFilmId(film.getFilmId());
		filmDto.setTitle(film.getTitle());
		filmDto.setDescription(film.getDescription());
		return filmDto;
	}
}
package org.ismek.sakila;

import java.util.List;

import org.ismek.domain.Film;
import org.ismek.sakila.dto.FilmDto;
import org.ismek.service.FilmService;

public class SakilaFilmServiceImpl implements SakilaFilmService {

	@Override
	public FilmDto[] findAllFilm() {
		
		FilmDto[] filmDtoArray = new FilmDto[1];
		FilmDto fff = new FilmDto();
		fff.setTitle("TİTLE");
		filmDtoArray[0] = fff;
		
//		FilmService filmService = new FilmService();
//		List<Film> filmList = filmService.findAll();
//		FilmDto[] filmDtoArray = new FilmDto[filmList.size()];
//		int index = 0;
//		FilmConverter filmConverter = new FilmConverter();
//		for (Film film : filmList) {
//			FilmDto filmDto = filmConverter.convertToFilmDto(film);
//			filmDtoArray[index] = filmDto;
//			index++;
//		}
		return filmDtoArray;
	}
}
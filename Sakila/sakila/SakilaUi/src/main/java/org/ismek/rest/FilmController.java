package org.ismek.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ismek.domain.Film;
import org.ismek.service.FilmService;

@Path("/film")
public class FilmController {

	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllFilmList() {
		FilmService filmService = new FilmService();
		List<Film> filmList = filmService.findAll();
		return Response.status(200).entity(filmList).build();
	}

	@POST
	@Path("/findById")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded;charset=UTF-8")
	public Response findById(@FormParam(value = "filmId") Long filmId) {
		FilmService filmService = new FilmService();
		Film film = filmService.findById(filmId);
		return Response.status(200).entity(film).build();
	}
	
	@POST
	@Path("/saveFilm")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveFilm(Film film) {
		FilmService filmService = new FilmService();
		Film savedFilm = filmService.save(film);
		return Response.status(200).entity(savedFilm).build();
	}
}
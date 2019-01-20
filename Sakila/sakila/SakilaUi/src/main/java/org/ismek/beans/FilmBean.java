package org.ismek.beans;

import org.ismek.domain.Film;
import org.ismek.domain.Language;
import org.ismek.service.FilmService;
import org.ismek.service.LanguageService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "filmBean")
@RequestScoped
public class FilmBean {

	private Long id;
	private String title;
	private String description;
	private Language language;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void kaydet() {
		
		Film film = new Film();
		film.setFilmId(id);
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage(language);
		
		FilmService filmService = new FilmService();
		Film savedFilm = filmService.save(film);
		if (savedFilm != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kayıt başarılı"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kayıt başarısız"));
		}
		yeni();
	}

	public List<Film> findAllFilm() {
		FilmService filmService = new FilmService();
		return filmService.findAllFilmByLanguageName("English");
	}

	public void guncelle(Film film) {
		this.id = film.getId();
		this.title = film.getTitle();
		this.description = film.getDescription();
		this.language = film.getLanguage();
	}

	public void sil(Film film) {
		FilmService filmService = new FilmService();
		filmService.delete(film);
	}

	public void yeni() {
		this.id = null;
		this.title = "";
		this.description = "";
		this.language = null;
	}

	public List<Language> findAllLanguage() {
		LanguageService languageService = new LanguageService();
		return languageService.findAll();
	}
}
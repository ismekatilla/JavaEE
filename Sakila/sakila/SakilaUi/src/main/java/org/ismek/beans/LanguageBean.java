package org.ismek.beans;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.ismek.domain.Language;
import org.ismek.service.LanguageService;

@ManagedBean(name = "languageBean")
@RequestScoped
public class LanguageBean {

	private Long id;
	private String name;
	private Date lastUpdate = new Date();
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void kaydet() {
		
		Language language = new Language();
		language.setLanguageId(id);
		language.setName(name);
		language.setLastUpdate(lastUpdate);
		
		LanguageService languageService = new LanguageService();
		Language savedLanguage = languageService.save(language);
		if (savedLanguage != null) {
			id = savedLanguage.getId();
			name = savedLanguage.getName();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kayıt başarılı"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kayıt başarısız"));
		}
		yeni();
	}

	public List<Language> findAllLanguage() {
		LanguageService languageService = new LanguageService();
		return languageService.findAll();
	}

	public void guncelle(Language language) {
		this.name = language.getName();
		this.lastUpdate = language.getLastUpdate();
		this.id = language.getId();
	}

	public void sil(Language language) {
		LanguageService languageService = new LanguageService();
		languageService.delete(language);
	}

	public void yeni() {
		this.id = null;
		this.name = "";
		this.lastUpdate = new Date();
	}
}
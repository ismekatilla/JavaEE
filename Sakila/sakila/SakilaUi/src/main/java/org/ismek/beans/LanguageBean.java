package org.ismek.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.ismek.domain.Language;
import org.ismek.service.LanguageService;

@ManagedBean(name = "languageBean")
@RequestScoped
public class LanguageBean {

	private Long id;
	private String name;
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
		language.setLastUpdate(new Date());
		
		LanguageService languageService = new LanguageService();
		Language savedLanguage = languageService.save(language);
		if (savedLanguage != null) {
			id = savedLanguage.getId();
			name = savedLanguage.getName();
			message = "Kayıt başarılı";
		} else {
			message = "Kayıt başarısız.";
		}
	}
}
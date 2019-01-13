package org.ismek.dto;

import org.ismek.domain.BaseDomain;

public class SakilaFilmDto extends BaseDomain {
	private Long filmId;
	private String title;
	private String description;

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return filmId;
	}
}
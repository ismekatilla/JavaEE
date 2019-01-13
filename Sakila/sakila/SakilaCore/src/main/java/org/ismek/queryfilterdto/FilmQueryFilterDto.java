package org.ismek.queryfilterdto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.ismek.domain.Film;

public class FilmQueryFilterDto extends QueryFilterDto<Film> {

	private String title;
	private String description;
	private Long languageId;

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

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	@Override
	public void addWhereClause(CriteriaBuilder criteriaBuilder, CriteriaQuery<Film> query) {
		Root root = (Root) query.getRoots().toArray()[0];
		
		List<Predicate> predicateList = new ArrayList<Predicate>();
		if (title != "") {
			Predicate titleClause = criteriaBuilder.equal(root.get("title"), title);
			predicateList.add(titleClause);
		}
		if (description != "") {
			Predicate descriptionClause = criteriaBuilder.equal(root.get("description"), description);
			predicateList.add(descriptionClause);
		}
		
		Predicate[] pp = new Predicate[predicateList.size()];
		query.where(predicateList.toArray(pp));
	}
}
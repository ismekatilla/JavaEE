package org.ismek.queryfilterdto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.ismek.domain.Film;
import org.ismek.domain.Language;

public class LanguageQueryFilterDto extends QueryFilterDto<Language> {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addWhereClause(CriteriaBuilder criteriaBuilder, CriteriaQuery<Language> query) {
		Root root = (Root) query.getRoots().toArray()[0];
		
		List<Predicate> predicateList = new ArrayList<Predicate>();
		if (name != "") {
			Predicate titleClause = criteriaBuilder.equal(root.get("name"), name);
			predicateList.add(titleClause);
		}
		Predicate[] pp = new Predicate[predicateList.size()];
		query.where(predicateList.toArray(pp));
	}
}
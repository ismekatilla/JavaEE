package org.ismek.queryfilterdto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class QueryFilterDto <T> {

	public abstract void addWhereClause(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> query);
}
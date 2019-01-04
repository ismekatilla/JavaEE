package org.ismek.service;

import java.util.List;

import org.ismek.dao.ActorDao;
import org.ismek.dao.BaseDao;
import org.ismek.domain.Actor;
import org.ismek.domain.BaseDomain;

public class BaseService<T extends BaseDomain> {

	private BaseDao<T> dao;
	
	public BaseService(Class entity) {
		dao = new BaseDao<T>(entity);
	}
	
	public List<T> findAll() {
		return dao.findAll();
	}
	
	public T save(T entity) {
		return dao.save(entity);
	}
	
	public T findById(Long entityId) {
		return dao.findById(entityId);
	}
}
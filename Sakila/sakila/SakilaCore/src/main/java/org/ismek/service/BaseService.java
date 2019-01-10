package org.ismek.service;

import org.ismek.dao.BaseDao;
import org.ismek.domain.BaseDomain;

import java.util.List;

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

	public void delete(T entity) {
		dao.delete(entity);
	}
}
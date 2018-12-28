package org.ismek.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ismek.domain.BaseDomain;
import org.ismek.utils.HibernateUtil;

public class BaseDao <T extends BaseDomain> {

	private static Logger logger = LogManager.getLogger(BaseDao.class);
	
	Class<T> entity;
	
	public BaseDao(Class<T> entity) {
		this.entity = entity;
	}
	
	public T save(T entity) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			return (T) session.merge(entity);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	public List<T> findAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			String simpleName = entity.getSimpleName();
			String lowerCaseSimpleName = simpleName.toLowerCase();
			Query createQuery = session.createQuery("Select " + lowerCaseSimpleName + " From " + simpleName + " " + lowerCaseSimpleName);
			return (List<T>) createQuery.list();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}

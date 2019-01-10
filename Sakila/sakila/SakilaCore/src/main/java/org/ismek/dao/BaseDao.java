package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.ismek.domain.BaseDomain;
import org.ismek.utils.HibernateUtil;

import java.util.List;

public class BaseDao <T extends BaseDomain> {

	private static Logger logger = LogManager.getLogger(BaseDao.class);
	
	Class<T> entity;
	
	public BaseDao(Class<T> entity) {
		this.entity = entity;
	}
	
	public T save(T entity) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Transaction tx2 = session.beginTransaction();
			T savedEntity = (T) session.merge((String) null, entity);
			tx2.commit();
			return savedEntity;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
		
	public List<T> findAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			String simpleName = entity.getSimpleName();
			Query createQuery = session.createQuery(" From " + simpleName);
			return (List<T>) createQuery.list();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	public T findById(Long entityId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			return session.get(entity, entityId);
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	public void delete(T entity) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Transaction tx2 = session.beginTransaction();
			session.delete(entity);
			tx2.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}

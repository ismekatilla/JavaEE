package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.ismek.domain.BaseDomain;
import org.ismek.queryfilterdto.QueryFilterDto;
import org.ismek.utils.HibernateUtil;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	
	public List<T> findAllByQueryFilterDto(QueryFilterDto queryFilterDto) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<T> query = criteriaBuilder.createQuery(entity);
			Root<T> root = query.from(entity);
			query.select(root);
			queryFilterDto.addWhereClause(criteriaBuilder, query);
			Query<T> createQuery = session.createQuery(query);
			return (List<T>) createQuery.getResultList();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}

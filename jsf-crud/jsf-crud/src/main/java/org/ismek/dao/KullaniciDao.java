package org.ismek.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.ismek.domain.Kullanici;
import org.ismek.utils.HibernateUtil;

public class KullaniciDao {
	
	private static Logger logger = LogManager.getLogger(KullaniciDao.class);

	public List<Kullanici> findAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("From Kullanici");
			return (List<Kullanici>) query.list();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	public Kullanici save(Kullanici entity) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Kullanici savedEntity = (Kullanici) session.merge(entity);
			transaction.commit();
			return savedEntity;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	public Kullanici findById(Long kullaniciId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			return session.get(Kullanici.class, kullaniciId);
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}
package org.ismek.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ismek.domain.Actor;
import org.ismek.utils.HibernateUtil;

public class ActorDao {
	
	private static Logger logger = LogManager.getLogger(ActorDao.class);

	public List<Actor> findAllActor() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Query createQuery = session.createQuery("Select actor From Actor actor");
			return (List<Actor>) createQuery.list();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
}
package org.ismek.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ismek.domain.Film;
import org.ismek.utils.HibernateUtil;

public class FilmDao extends BaseDao<Film> {
	
	private static Logger logger = LogManager.getLogger(FilmDao.class);
	
	public FilmDao() {
		super(Film.class);
	}
	
	public List<Film> findAllFilmByLanguageName(String languageName) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			String hql = 
					"Select	film From " +
					"Film film " +
					"Left Join film.language language " +
					"Where language.name = :name";
			Query query = session.createQuery(hql);
			query.setParameter("name", languageName);
			return (List<Film>) query.list();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}
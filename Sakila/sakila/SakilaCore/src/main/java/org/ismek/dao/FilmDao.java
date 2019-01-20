package org.ismek.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.ismek.domain.Film;
import org.ismek.dto.FilmRatingDto;
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
	
	public List<FilmRatingDto> groupByRating() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			String hql = 
					"Select		film.rating as rating, count(film.id) as count " +
					"From 		Film film " +
					"Group By 	film.rating " + 
					"Having		count(film.id) > 200";
			Query query = session.createQuery(hql);
			query.setResultTransformer(Transformers.aliasToBean(FilmRatingDto.class));
			return (List<FilmRatingDto>) query.list();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	public List<FilmRatingDto> groupByRatingNative() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			String sql = 
					"select		rating as rating, count(*) as count " + 
					"from 		film " + 
					"group by 	rating having count(*) > 200 ";
			Query query = session.createNativeQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(FilmRatingDto.class));
			return (List<FilmRatingDto>) query.list();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}
package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ismek.domain.City;
import org.ismek.utils.HibernateUtil;

import java.util.List;

public class CityDao extends BaseDao<City> {
	
	private static Logger logger = LogManager.getLogger(CityDao.class);
	
	public CityDao() {
		super(City.class);
	}

	public List<City> findAllCityByCountryId(Long countryId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("Select city From City city Where city.country.id = :countryId");
			query.setParameter("countryId", countryId);
			return query.list();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}
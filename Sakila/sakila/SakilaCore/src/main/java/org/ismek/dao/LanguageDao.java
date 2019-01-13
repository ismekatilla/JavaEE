package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ismek.domain.Language;
import org.ismek.utils.HibernateUtil;

public class LanguageDao extends BaseDao<Language> {
	
	private static Logger logger = LogManager.getLogger(LanguageDao.class);
	
	public LanguageDao() {
		super(Language.class);
	}
	
	public Language findByIdEager(Long languageId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("Select language From Language language Left Join Fetch language.filmSet Where language.languageId = :languageId");
			query.setParameter("languageId", languageId);
			return (Language) query.uniqueResult();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}
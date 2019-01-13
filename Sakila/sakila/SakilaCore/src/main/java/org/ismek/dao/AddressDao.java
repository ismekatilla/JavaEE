package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ismek.domain.Address;
import org.ismek.queryfilterdto.AddressQueryFilterDto;
import org.ismek.utils.HibernateUtil;

import java.util.List;

public class AddressDao extends BaseDao<Address> {
	
	private static Logger logger = LogManager.getLogger(AddressDao.class);
	
	public AddressDao() {
		super(Address.class);
	}

	public List<Address> findAllAddressByQueryFilterDto(AddressQueryFilterDto addressQueryFilterDto) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			String hql =
					"select 	address " + 
					"from 		Address address " +
					"where		1=1 ";
			if (addressQueryFilterDto.getCountryId() != null) {
				hql += " and address.city.country.countryId = " + addressQueryFilterDto.getCountryId();
			}

			if (addressQueryFilterDto.getCityId() != null) {
				hql += " and address.city.cityId = " + addressQueryFilterDto.getCityId();
			}
			Query createQuery = session.createQuery(hql);
			return (List<Address>) createQuery.list();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}
package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Country;

public class CountryDao extends BaseDao<Country> {
	
	private static Logger logger = LogManager.getLogger(CountryDao.class);
	
	public CountryDao() {
		super(Country.class);
	}
}
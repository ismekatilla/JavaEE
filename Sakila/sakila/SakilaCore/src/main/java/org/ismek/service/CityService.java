package org.ismek.service;

import org.ismek.dao.CityDao;
import org.ismek.domain.City;

import java.util.List;

public class CityService extends BaseService<City> {

	public CityService() {
		super(City.class);
	}

	public List<City> findAllCityByCountryId(Long countryId) {
		CityDao cityDao = new CityDao();
		return cityDao.findAllCityByCountryId(countryId);
	}
}
package org.ismek.component.beans;

import org.ismek.domain.Country;
import org.ismek.service.CountryService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "countryBean")
@RequestScoped
public class CountryBean {

	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Country> findAllCountry() {
		CountryService countryService = new CountryService();
		return countryService.findAll();
	}
}
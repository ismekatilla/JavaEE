package org.ismek.beans;

import org.ismek.domain.Address;
import org.ismek.domain.City;
import org.ismek.domain.Country;
import org.ismek.queryfilterdto.AddressQueryFilterDto;
import org.ismek.service.AddressService;
import org.ismek.service.CityService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "addressBean")
@SessionScoped
public class AddressBean {

	private Country country;
	private City city;
	private List<City> cityList = new ArrayList<City>();
	private List<Address> addressList = new ArrayList<Address>();

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public void ara() {

		AddressQueryFilterDto addressQueryFilterDto = new AddressQueryFilterDto();
		if (country != null) {
			addressQueryFilterDto.setCountryId(country.getCountryId());
		}
		if (city != null) {
			addressQueryFilterDto.setCityId(city.getCityId());
		}

		AddressService addressService = new AddressService();
		addressList = addressService.findAllAddressByQueryFilterDto(addressQueryFilterDto);
	}

	public void countryChanged() {
		CityService cityService = new CityService();
		if (country != null) {
			cityList = cityService.findAllCityByCountryId(country.getCountryId());
		}
	}
}
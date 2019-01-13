package org.ismek.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Country")
public class Country extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private Long countryId;

	@Column(name = "country", length = 50)
	private String country;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@Override
	public Long getId() {
		return countryId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
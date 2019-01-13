package org.ismek.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "City")
public class City extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Long cityId;

	@Column(name = "city", length = 50)
	private String city;

	@ManyToOne
	@JoinColumn(name = "country_id", foreignKey = @ForeignKey(foreignKeyDefinition = "fk_city_country"))
	private Country country;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;

	@Override
	public Long getId() {
		return cityId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
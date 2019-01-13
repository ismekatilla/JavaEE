package org.ismek.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Address")
public class Address extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long addressId;

	@Column(name = "address", length = 50)
	private String address;

	@Column(name = "address2", length = 50)
	private String address2;

	@Column(name = "district", length = 20)
	private String district;

	@ManyToOne
	@JoinColumn(name = "city_id", foreignKey = @ForeignKey(foreignKeyDefinition = "fk_address_city"))
	private City city;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;

	@Override
	public Long getId() {
		return addressId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
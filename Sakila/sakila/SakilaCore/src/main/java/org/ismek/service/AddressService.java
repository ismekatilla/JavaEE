package org.ismek.service;

import org.ismek.dao.AddressDao;
import org.ismek.domain.Address;
import org.ismek.queryfilterdto.AddressQueryFilterDto;

import java.util.List;

public class AddressService extends BaseService<Address> {

	public AddressService() {
		super(Address.class);
	}

	public List<Address> findAllAddressByQueryFilterDto(AddressQueryFilterDto addressQueryFilterDto) {
		AddressDao addressDao = new AddressDao();
		return addressDao.findAllAddressByQueryFilterDto(addressQueryFilterDto);
	}
}
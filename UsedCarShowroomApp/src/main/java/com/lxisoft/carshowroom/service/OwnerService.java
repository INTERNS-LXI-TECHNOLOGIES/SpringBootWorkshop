package com.lxisoft.carshowroom.service;

import com.lxisoft.carshowroom.entity.Owner;

public interface OwnerService {

	void saveOwner(Owner owner);
	Owner getOwner(long phoneNumber);
	void deleteOwner(long phoneNumber);

}

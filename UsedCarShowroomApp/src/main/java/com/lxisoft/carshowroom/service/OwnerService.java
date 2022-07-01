package com.lxisoft.carshowroom.service;

import java.util.List;

import com.lxisoft.carshowroom.entity.Owner;

public interface OwnerService {

	Owner saveOwner(Owner owner);

	Owner getOwner(Integer id);

	void deleteOwner(Integer id);

	List<Owner> getOwners();

}

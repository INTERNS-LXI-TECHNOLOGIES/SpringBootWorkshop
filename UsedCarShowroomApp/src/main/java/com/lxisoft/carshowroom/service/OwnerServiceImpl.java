package com.lxisoft.carshowroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.carshowroom.entity.Owner;
import com.lxisoft.carshowroom.repository.OwnerRepository;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public Owner saveOwner(Owner owner) {
		if (null != owner.getId()) {
			Owner ownerFromDb = getOwner(owner.getId());
			owner.setCars(ownerFromDb.getCars());
		}
		return ownerRepository.save(owner);
	}

	@Override
	public Owner getOwner(Integer id) {
		return ownerRepository.findById(id).get();
	}

	@Override
	public void deleteOwner(Integer id) {
		Owner owner = getOwner(id);
		owner.getCars().clear();
		ownerRepository.save(owner);
		ownerRepository.deleteById(id);
	}

	@Override
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}

}

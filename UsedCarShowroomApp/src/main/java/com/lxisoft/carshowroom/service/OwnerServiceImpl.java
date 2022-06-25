package com.lxisoft.carshowroom.service;

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
	public void saveOwner(Owner owner) {
		ownerRepository.save(owner);
	}

	@Override
	public Owner getOwner(long phoneNumber) {
		return ownerRepository.findById(phoneNumber).get();
	}

	@Override
	public void deleteOwner(long phoneNumber) {
		ownerRepository.deleteById(phoneNumber);
	}

}

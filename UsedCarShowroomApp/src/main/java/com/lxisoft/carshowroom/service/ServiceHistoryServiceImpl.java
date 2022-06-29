package com.lxisoft.carshowroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.carshowroom.entity.ServiceHistory;
import com.lxisoft.carshowroom.repository.ServiceHistoryRepository;

@Service
@Transactional
public class ServiceHistoryServiceImpl implements ServiceHistoryService {

	@Autowired
	private ServiceHistoryRepository ServiceHistoryRepository;

	@Override
	public void saveServiceHistory(ServiceHistory ServiceHistory) {
		ServiceHistoryRepository.save(ServiceHistory);
	}

	@Override
	public ServiceHistory getServiceHistory(Integer id) {
		return ServiceHistoryRepository.findById(id).get();
	}

	@Override
	public void deleteServiceHistory(Integer id) {
		ServiceHistoryRepository.deleteById(id);
	}

}

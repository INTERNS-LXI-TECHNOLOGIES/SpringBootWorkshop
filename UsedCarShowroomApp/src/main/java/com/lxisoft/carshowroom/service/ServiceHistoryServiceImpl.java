package com.lxisoft.carshowroom.service;

import java.util.Date;

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
	public ServiceHistory getServiceHistory(Date serviceDate) {
		return ServiceHistoryRepository.findById(serviceDate).get();
	}

	@Override
	public void deleteServiceHistory(Date serviceDate) {
		ServiceHistoryRepository.deleteById(serviceDate);
	}

}

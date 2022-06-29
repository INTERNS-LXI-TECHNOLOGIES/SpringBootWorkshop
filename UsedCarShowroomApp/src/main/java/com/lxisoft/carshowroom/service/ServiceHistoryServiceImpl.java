package com.lxisoft.carshowroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.lxisoft.carshowroom.entity.Car;
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

	@Override
	public String addOrEdit(Integer id, Model model, Car car) {
		ServiceHistory serviceHistory;
		if (id == null) {
			serviceHistory = new ServiceHistory();
			car.getServiceHistories().add(serviceHistory);
		} else {
			serviceHistory = getServiceHistory(id);
		}
		model.addAttribute("car", car);
		model.addAttribute("serviceHistory", serviceHistory);
		model.addAttribute("action", "view");
		return "carDetails";
	}

}

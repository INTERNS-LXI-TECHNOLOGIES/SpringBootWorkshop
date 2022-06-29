package com.lxisoft.carshowroom.service;

import org.springframework.ui.Model;

import com.lxisoft.carshowroom.entity.Car;
import com.lxisoft.carshowroom.entity.ServiceHistory;

public interface ServiceHistoryService {

	void saveServiceHistory(ServiceHistory ServiceHistory);

	ServiceHistory getServiceHistory(Integer id);

	void deleteServiceHistory(Integer id);

	String addOrEdit(Integer id, Model model, Car car);

}

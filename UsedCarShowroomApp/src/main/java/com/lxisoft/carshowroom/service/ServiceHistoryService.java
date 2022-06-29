package com.lxisoft.carshowroom.service;

import com.lxisoft.carshowroom.entity.ServiceHistory;

public interface ServiceHistoryService {

	void saveServiceHistory(ServiceHistory ServiceHistory);

	ServiceHistory getServiceHistory(Integer id);

	void deleteServiceHistory(Integer id);

}

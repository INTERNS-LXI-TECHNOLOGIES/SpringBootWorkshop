package com.lxisoft.carshowroom.service;

import java.util.Date;

import com.lxisoft.carshowroom.entity.ServiceHistory;

public interface ServiceHistoryService {

	void saveServiceHistory(ServiceHistory ServiceHistory);
	ServiceHistory getServiceHistory(Date serviceDate);
	void deleteServiceHistory(Date serviceDate);

}

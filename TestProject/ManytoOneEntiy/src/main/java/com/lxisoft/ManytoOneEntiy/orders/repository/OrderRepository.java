package com.lxisoft.ManytoOneEntiy.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot.springbootmultipledatasources.orders.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Integer>{

}
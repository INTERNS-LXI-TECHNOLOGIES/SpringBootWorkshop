package com.lxisoft.carshowroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.carshowroom.entity.CarUser;
import com.lxisoft.carshowroom.repository.CarUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	CarUserRepository carUserRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final CarUser carUser = carUserRepository.findById(username).orElse(null);
		if (carUser == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetails user = User.withUsername(carUser.getUsername()).password(carUser.getPassword()).authorities(carUser.getRole()).build();
		return user;
	}
}
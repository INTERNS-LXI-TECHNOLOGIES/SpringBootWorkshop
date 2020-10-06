package com.lxisoft.moviescript.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.moviescript.model.Movie;
import com.lxisoft.moviescript.repository.MovieRepo;


@org.springframework.stereotype.Service
public class Service {

	@Autowired
	MovieRepo mRepo;
	@Transactional
	public void saveMovie(Movie mov)
	{
		mRepo.save(mov);
	}
}

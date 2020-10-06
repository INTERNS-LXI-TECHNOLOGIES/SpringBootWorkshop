package com.lxisoft.moviescript.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8152706510804282874L;
	private String movieName;
	private String releaseDate;
	@Id
	private int movieCode;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}


}

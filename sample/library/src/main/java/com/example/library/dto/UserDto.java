package com.example.library.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
		
	    private String name;
	    private String address;
	    private Set<String> books = new HashSet<>();
	    
	    public UserDto() {}
	    
		public UserDto(String name, String address, Set<String> books) {
			super();
			this.name = name;
			this.address = address;
			this.books = books;
		}
		

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Set<String> getBooks() {
			return books;
		}
		public void setBooks(Set<String> books) {
			this.books = books;
		}

}

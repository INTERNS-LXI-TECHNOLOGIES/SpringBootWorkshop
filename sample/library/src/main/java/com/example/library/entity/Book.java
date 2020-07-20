package com.example.library.entity;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BOOK")
public class Book {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 
	    @Column(name = "name")
	    private String name;
	 
	    @Column(name = "author")
	    private String author;
	    
	    public Book(String name, String author, Set<User> users) {
			super();
			this.name = name;
			this.author = author;
			this.users = users;
		}

		@ManyToMany(mappedBy = "books")
	    private Set<User> users;
	    
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Set<User> getUsers() {
			return users;
		}

		public void setUsers(Set<User> users) {
			this.users = users;
		}

		
	
}

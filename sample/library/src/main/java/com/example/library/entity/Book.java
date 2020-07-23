package com.example.library.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	 
	    @Column
	    private String name;
	 
	    @Column
	    private String author;
	    
	    private String bok;
	    @ManyToMany(mappedBy = "books",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    private List<User> users;
	    
	    public Book() {
	    	
	    }
	    
	    public Book(Long id,String name, String author,String bok, List<User> users) {
	    	this.id = id;
			this.name = name;
			this.author = author;
			this.bok = bok;
			this.users = users;
		}
	    
		public long getId() {
			return id;
		}

		public void setId(long id) {
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
		public String getBook()
		{
			return bok;
		}
		public void setBook(String bok)
		{
			this.bok=bok;
		}
		
		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		
		  @Override public boolean equals(Object o) { if (this == o) return true; if
		  (!(o instanceof Book)) return false; Book book = (Book) o; return getName()
		  == book.getName() && Objects.equals(getId(), book.getId()) &&
		  Objects.equals(getName(), book.getName()) && Objects.equals(getAuthor(),
		  book.getAuthor()) && Objects.equals(getUsers(), book.getUsers()); }
		 

	    @Override
	    public String toString() {
	        return "Course{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", author='" + author + '\'' +
	                ", users=" + users +
	                '}';
	    }	
}

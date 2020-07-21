package com.example.library.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
	    
	    @ManyToMany(mappedBy = "books",fetch = FetchType.LAZY)
	    private Set<User> users = new HashSet<>();
	    
	    public Book() {
	    	
	    }
	    
	    public Book(Long id,String name, String author, Set<User> users) {
	    	this.id = id;
			this.name = name;
			this.author = author;
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

		public Set<User> getUsers() {
			return users;
		}

		public void setUsers(Set<User> users) {
			this.users = users;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Book)) return false;
	        Book book = (Book) o;
	        return getName() == book.getName() &&
	                Objects.equals(getId(), book.getId()) &&
	                Objects.equals(getName(), book.getName()) &&
	                Objects.equals(getAuthor(), book.getAuthor()) &&
	                Objects.equals(getUsers(), book.getUsers());
	    }
		@Override
	    public int hashCode() {
	        return Objects.hash(getId());
	    }

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

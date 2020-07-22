package com.example.library.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	 
	    @Column
	    private String name;
	    
	    @Column
	    private String address;
	 
	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	    	name = "USER_BOOK", joinColumns = {
	    	@JoinColumn(name = "USER_ID", referencedColumnName="id", nullable = false, updatable = false)},
	    	inverseJoinColumns = {
	            @JoinColumn(name = "BOOK_ID",referencedColumnName="id", nullable = false, updatable = false)})
	    
	    private Set<Book> books;
	    public User() {
	    }

		public User(Long id,String name, String address, Set<Book> books) {
			this.id=id;
			this.name = name;
			this.address = address;
			this.books = books;
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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Set<Book> getBooks() {
			return books;
		}

		public void setBooks(Set<Book> books) {
			this.books = books;
		}
		
		/*
		 * @Override public boolean equals(Object o) { if (this == o) return true; if
		 * (!(o instanceof User)) return false; User user = (User) o; return getName()
		 * == user.getName() && Objects.equals(getId(), user.getId()) &&
		 * Objects.equals(getName(), user.getName()) && Objects.equals(getAddress(),
		 * user.getAddress()) && Objects.equals(getBooks(), user.getBooks()); }
		 */
	
		  @Override
		    public String toString() {
		        return "User{" +
		                "id=" + id +
		                ", name='" + name + '\'' +
		                ", address=" + address +
		                ", books='" + books + '\'' +
		                '}';
		    }
		
		
	
}

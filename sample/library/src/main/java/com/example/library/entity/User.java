package com.example.library.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 
	    @Column(name = "name")
	    private String name;
	    
	    @Column(name = "addrress")
	    private String addrress;
	 
	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	    	name = "USER_BOOK", joinColumns =
	    	@JoinColumn(name = "USER_ID", referencedColumnName="id"),
	    	inverseJoinColumns = 
	            @JoinColumn(name = "BOOK_ID",referencedColumnName="id")
	    )

	    public User() {
	    }
	    
	    public User(String name, String addrress, Set<Book> books) {
			super();
			this.name = name;
			this.addrress = addrress;
			this.books = books;
		}
	    
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

		public String getAddrress() {
			return addrress;
		}

		public void setAddrress(String addrress) {
			this.addrress = addrress;
		}

		public Set<Book> getBooks() {
			return books;
		}

		public void setBooks(Set<Book> books) {
			this.books = books;
		}


	    private Set<Book> books;
	 
	    public void addBook(Book book) {
	        this.books.add(book);
	        book.getUsers().add(this);
	    }
	 
	    public void removeBook(Book book) {
	        this.getBooks().remove(book);
	        book.getUsers().remove(this);
	    }
	 
	    public void removeBooks() {
	        for (Book book : new HashSet<>(books)) {
	        	removeBook(book);
	        }
	    }
	
}

package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;

public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public void saveBook(Book book)
	{
		bookRepository.save(book);
	}
	
	public List<Book> getBook()
    {
        return bookRepository.findAll();
    }

}

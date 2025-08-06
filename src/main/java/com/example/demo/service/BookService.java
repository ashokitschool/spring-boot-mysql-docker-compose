package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;
	
	public boolean addBook(Book book) {
		try {
			repo.save(book);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Iterable<Book> fetchBooks() {
		return repo.findAll();
	}

}

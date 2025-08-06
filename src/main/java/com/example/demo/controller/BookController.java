package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired 
	BookService service;
	
	@PostMapping( value = "/add", consumes = "application/json")
	public ResponseEntity<String> createBook(@RequestBody Book book)
	{
		if(service.addBook(book))
			return new ResponseEntity<>("Book is stored in Database", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Failed to store the book in Database", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping( value = "/fetch" , produces = "application/json")
	public ResponseEntity<Iterable<Book>> readBooks() {
		return new ResponseEntity<>(service.fetchBooks(), HttpStatus.OK);
	}

}

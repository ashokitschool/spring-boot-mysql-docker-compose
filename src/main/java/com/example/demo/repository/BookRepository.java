package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}

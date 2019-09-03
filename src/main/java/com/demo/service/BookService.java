package com.demo.service;

import com.demo.model.Book;

import java.util.List;

public interface BookService {
  List<Book> findAll();
  Book getBookFindByName(String name);
  Book findById(Long id);
  void save(Book book);
 void remove(Book book);
}

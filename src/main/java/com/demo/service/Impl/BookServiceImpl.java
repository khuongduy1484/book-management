package com.demo.service.Impl;

import com.demo.model.Book;
import com.demo.repository.BookRepository;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
//@Transactional(rollbackFor = Exception.class,readOnly = false)
public class BookServiceImpl implements BookService {
  @Autowired
  private BookRepository bookRepository;
  @Override
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public Book findById(Long id) {
    return bookRepository.findById(id).get();
  }

  @Override
  public void save(Book book) {
    bookRepository.save(book);

  }

  @Override
  public void remove(Book book) {
bookRepository.delete(book);
  }
}

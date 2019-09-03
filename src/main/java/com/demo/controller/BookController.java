package com.demo.controller;

import com.demo.message.request.BookForm;
import com.demo.message.response.ResponseMessage;
import com.demo.model.Author;
import com.demo.model.Book;
import com.demo.model.Category;
import com.demo.model.CategoryName;
import com.demo.service.AuthorService;
import com.demo.service.BookService;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
//@Transactional(rollbackFor = Exception.class)
public class BookController {
  @Autowired
  BookService bookService;
  @Autowired
  CategoryService categoryService;
  @Autowired
  AuthorService authorService;
  @PostMapping
  public ResponseEntity<?>createBook(@RequestBody BookForm bookForm){


    Author author =authorService.findByName(bookForm.getAuthor());
    Book book = new Book(bookForm.getName(),bookForm.getContent(),bookForm.getProducer());
    Category category = categoryService.findByName(bookForm.getCategory());
    book.setCategory(category);
    book.setAuthor(author);
    bookService.save(book);
    return new ResponseEntity<>(new ResponseMessage("Publish book successfully "), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?>updateBook(@PathVariable("id") Long id,@RequestBody BookForm b){
    Author author = authorService.findByName(b.getAuthor());
    Book book = bookService.findById(id);
    book.setName(b.getName());
    bookService.save(book);
    book.setAuthor(author);
    Category category = categoryService.findByName(b.getCategory());
    book.setCategory(category);
    book.setContent(b.getContent());
    book.setProducer(b.getProducer());
    bookService.save(book);
    return new ResponseEntity<>(new ResponseMessage("Update book successfully "), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Book>>fillAll(){
    List<Book> books = bookService.findAll();
    return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
  }

  @GetMapping("{id}")
  public ResponseEntity<?>book(@PathVariable("id") Long id){
    Book book = bookService.findById(id);
    return new ResponseEntity<>(book,HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?>deleteBook(@PathVariable("id") Long id){
    Book book = bookService.findById(id);
    bookService.remove(book);
    return new ResponseEntity<>(new ResponseMessage("remove successfully"),HttpStatus.OK);
  }

}

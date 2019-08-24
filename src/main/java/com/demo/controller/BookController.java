package com.demo.controller;

import com.demo.message.request.BookForm;
import com.demo.message.response.ResponseMessage;
import com.demo.model.Book;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
  @Autowired
  BookService bookService;
  @PostMapping
  public ResponseEntity<?>createBook(@RequestBody Book book){
    bookService.save(book);
    return new ResponseEntity<>(new ResponseMessage("Publish book successfully "), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?>updateBook(@PathVariable("id") Long id,@RequestBody BookForm b){
    Book book = bookService.findById(id);
    book.setName(b.getName());
    book.setAuthor(b.getAuthor());
    book.setContent(b.getContent());
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

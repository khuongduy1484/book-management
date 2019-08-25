package com.demo.controller;

import com.demo.message.request.BookForm;
import com.demo.message.response.ResponseMessage;
import com.demo.model.Author;
import com.demo.model.Book;
import com.demo.model.Category;
import com.demo.service.AuthorService;
import com.demo.service.BookService;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookController {
  @Autowired
  BookService bookService;
  @Autowired
  CategoryService categoryService;
  @Autowired
  AuthorService authorService;

  @POST
  @Path("")
  public ResponseEntity<?> createBook(@RequestBody BookForm bookForm) {

    Category category = categoryService.findByName(bookForm.getCategory());

    Author author = authorService.findByName(bookForm.getAuthor());
    Book book = new Book(bookForm.getName(), bookForm.getContent(), bookForm.getProducer());
    book.setCategory(category);
    book.setAuthor(author);
    bookService.save(book);
    return new ResponseEntity<>(new ResponseMessage("Publish book successfully "), HttpStatus.OK);
  }

  @PUT
  @Path("/{id}")
  public ResponseEntity<?> updateBook(@PathParam("id") Long id, BookForm b) {
    Book book = bookService.findById(id);
    Category category = categoryService.findByName(b.getCategory());
    Author author = authorService.findByName(b.getAuthor());
    book.setAuthor(author);
    book.setCategory(category);
    book.setName(b.getName());
    book.setContent(b.getContent());
    bookService.save(book);
    return new ResponseEntity<>(new ResponseMessage("Update book successfully "), HttpStatus.OK);
  }

  @GET
  @Path("")
  public ResponseEntity<List<Book>> fillAll() {
    List<Book> books = bookService.findAll();
    return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
  }

@GET
@Path("{id}")
  public ResponseEntity<?> book(@PathVariable("id") Long id) {
    Book book = bookService.findById(id);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }

@DELETE
@Path("{id}")
  public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
    Book book = bookService.findById(id);
    bookService.remove(book);
    return new ResponseEntity<>(new ResponseMessage("remove successfully"), HttpStatus.OK);
  }

}

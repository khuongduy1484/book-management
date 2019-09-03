package com.demo;

import com.demo.model.Author;
import com.demo.model.Book;
import com.demo.model.Category;
import com.demo.repository.AuthorRepository;
import com.demo.repository.BookRepository;
import com.demo.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DemoApplicationTests {
  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private AuthorRepository authorRepository;

  @Test
  public void findByName_thenReturnBook() {
    Book book = new Book("sach", "hay", "kim");
    Category category = categoryRepository.findByName("truyen tranh");
    Author author = authorRepository.findByName("Duy");
    book.setCategory(category);
    book.setAuthor(author);
   bookRepository.save(book);
    Book book1 = bookRepository.findByName("sach");
    assertThat(book.getName())
      .isEqualTo(book1.getName());
  }
@Test
public void testSaveEmployee() {

  Book book = new Book("admin", "ad", "admin");
  Category category = categoryRepository.findByName("truyen tranh");
  Author author = authorRepository.findByName("Duy");
  book.setCategory(category);
  book.setAuthor(author);
  bookRepository.save(book);
  Book book1 = bookRepository.findByName("admin");
  assertNotNull(book);
  assertEquals(book1.getName(), book.getName());
}

  @Test
  public void testGetBookByName() {
    Book fromDb = bookRepository.findByName("a");
    assertThat(fromDb).isNotNull();
  }

  @Test
  public void deleteBookTest(){
    Book book = new Book("bb","bb","bb");
    Category category = categoryRepository.findByName("truyen tranh");
    Author author = authorRepository.findByName("Duy");
    book.setCategory(category);
    book.setAuthor(author);
    bookRepository.save(book);
    bookRepository.delete(book);
  }
}

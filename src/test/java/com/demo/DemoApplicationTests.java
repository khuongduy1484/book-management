package com.demo;

import com.demo.model.Book;
import com.demo.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoApplicationTests {
  @Autowired
  private TestEntityManager entityManager;
  @Autowired
  private BookRepository bookRepository;


  @Test
  public void findByName_thenReturnBook() {
    Book book = new Book("sach", "haylam", "kimdong");
    entityManager.persist(book);
    entityManager.flush();

    Book book1 = bookRepository.findByName(book.getName());
    assertThat(book.getName())
      .isEqualTo(book1.getName());
  }

  @Test
  public void whenInvalidName_thenReturnNull() {
    Book fromDb = bookRepository.findByName("doesNotExist");
    assertThat(fromDb).isNull();

  }
}

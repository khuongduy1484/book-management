package com.demo.model;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Size(min = 2,max = 50)
  @NotNull
  private String name;
  @NotNull

  @NotNull
  @Size(min = 2,max = 1000)
  private String content;
  @NotNull
  @Size(min = 2,max =10)
  private String producer;
  @ManyToOne
  private Category category;
  @ManyToOne
  private Author author;

  public Book() {
  }

  public Book(@Size(min = 2, max = 10) @NotNull String name,  @NotNull @Size(min = 2, max = 1000) String content, @NotNull @Size(min = 2, max = 1000) String producer) {
    this.name = name;
    this.content = content;
    this.producer = producer;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }
}

package com.demo.message.request;

public class BookForm {
  private String name;
  private String content;
  private String category;
  private String producer;
  private String author;

  public BookForm() {
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}

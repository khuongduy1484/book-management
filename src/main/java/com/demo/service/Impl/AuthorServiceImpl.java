package com.demo.service.Impl;

import com.demo.model.Author;
import com.demo.repository.AuthorRepository;
import com.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
  @Autowired
  private AuthorRepository authorRepository;

  @Override
  public Author findByName(String name) {
    return authorRepository.findByName(name);
  }
}

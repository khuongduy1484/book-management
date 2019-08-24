package com.demo.service;

import com.demo.model.Author;

public interface AuthorService {
  Author findByName(String name);
}

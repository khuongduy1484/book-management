package com.demo.service;

import com.demo.model.Category;

public interface CategoryService {
  Category findById(Long id);
  Category findByName(String name);
}

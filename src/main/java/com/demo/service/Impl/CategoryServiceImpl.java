package com.demo.service.Impl;

import com.demo.model.Category;
import com.demo.repository.CategoryRepository;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;
  @Override
  public Category findById(Long id) {
    return categoryRepository.findById(id).get();
  }

  @Override
  public Category findByName(String name) {
    return categoryRepository.findByName(name);
  }
}

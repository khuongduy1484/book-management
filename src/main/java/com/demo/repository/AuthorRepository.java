package com.demo.repository;

import com.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface AuthorRepository extends JpaRepository<Author,Long> {
  Author findByName(String name);
}

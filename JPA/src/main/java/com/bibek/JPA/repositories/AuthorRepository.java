package com.bibek.JPA.repositories;

import com.bibek.JPA.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}

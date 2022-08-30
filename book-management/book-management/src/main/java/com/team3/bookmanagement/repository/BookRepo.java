package com.team3.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team3.bookmanagement.entity.Book;

@Repository("bookRepo")
public interface BookRepo extends JpaRepository<Book, Long>{
	Book findByNameIgnoreCase(String name);
}

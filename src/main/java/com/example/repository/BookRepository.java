package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%',?1, '%'))")
	Page<Book> findByTitle(String bookTitle, Pageable pageRequest);
}

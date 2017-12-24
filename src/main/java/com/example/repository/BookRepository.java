package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

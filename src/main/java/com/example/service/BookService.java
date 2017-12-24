package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> listBook() {
		List<Book> books = bookRepository.findAll();
		return books;
	}
	
	public Book getBook(long bookId) {
		return bookRepository.getOne(bookId);
	}
	
	public Book saveBook(Book book) {
		book.setCreatedAt(new Date());
		return bookRepository.saveAndFlush(book);
	}
	
	public Book updateBook(Book book) {
		Book bookOrigin = bookRepository.findOne(book.getBookId());
		book.setUpdatedAt(new Date());
		book.setCreatedAt(bookOrigin.getCreatedAt());
		return bookRepository.saveAndFlush(book);
	}
	
	public void deleteBook(long bookId) {
		bookRepository.delete(bookId);
	}
}

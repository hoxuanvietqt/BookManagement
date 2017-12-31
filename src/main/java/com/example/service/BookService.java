package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.models.Book;
import com.example.models.SearchCriteria;
import com.example.repository.BookRepository;

@Service
public class BookService {
	
	private final static int PAGESIZE = 3;
	
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
	
	public Page<Book> getBookByTitle(SearchCriteria search) {
		PageRequest pageRequest = new PageRequest(search.getPageNumber() - 1, PAGESIZE, Sort.Direction.ASC, "bookId");
		Page<Book> bookResults = bookRepository.findByTitle(search.getBookTitle(), pageRequest);
		return bookResults;
	}
}

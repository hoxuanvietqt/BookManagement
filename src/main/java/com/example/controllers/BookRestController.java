package com.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Book;
import com.example.models.SearchCriteria;
import com.example.service.BookService;

@RestController
public class BookRestController {
	
	@Autowired
	private BookService bookService;
	   
	@PostMapping("/api/book/search")
	public ResponseEntity<?> viewBooks(@Valid @RequestBody SearchCriteria search, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body("error!");
        }
        
		Page<Book> books = bookService.getBookByTitle(search);

		return ResponseEntity.ok(books);
	}
}

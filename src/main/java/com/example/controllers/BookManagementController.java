package com.example.controllers;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Book;
import com.example.service.BookService;

@Controller
public class BookManagementController {

   @Autowired
   private BookService bookService;

   @RequestMapping(value = { "/", "/bookList" }, method = RequestMethod.GET)
   public String bookList(Model model, Principal principal) {
	   model.addAttribute("userInfo", principal.getName());
       model.addAttribute("books", bookService.listBook());

       return "bookList";
   }

   @RequestMapping(value = { "/addBook" }, method = RequestMethod.GET)
   public String showAddBookPage(Model model) {

       Book book = new Book();
       model.addAttribute("book", book);

       return "addBook";
   }

   @RequestMapping(value = { "/addBook" }, method = RequestMethod.POST)
   public String saveBook(Model model, @Valid Book book, BindingResult results) {

       if (results.hasErrors()) {
    	   model.addAttribute("book", book);
    	   return "addBook";
       }

       bookService.saveBook(book);
       
       return "redirect:/bookList";
   }
   
   @RequestMapping(value = { "/updateBook" }, method = RequestMethod.GET)
   public String showUpdateBook(Model model, @RequestParam(value = "bookId", required = true)long bookId) {

       model.addAttribute("book", bookService.getBook(bookId));
       
       return "updateBook";
   }
   
   @RequestMapping(value = { "/updateBook" }, method = RequestMethod.POST)
   public String updateBook(Model model, @Valid Book book, BindingResult results) {

       if (results.hasErrors()) {
    	   model.addAttribute("book", book);
    	   return "updateBook";
       }

       bookService.updateBook(book);
       
       return "redirect:/bookList";
   }
   
   @RequestMapping(value = { "/deleteBook" }, method = RequestMethod.GET)
   public String deleteBook(@RequestParam(value = "bookId", required = true)long bookId) {

       bookService.deleteBook(bookId);

       return "redirect:/bookList";
   }
   
   @RequestMapping(value = { "/bookDetail" }, method = RequestMethod.GET)
   public String bookDetail(Model model, @RequestParam(value = "bookId", required = true)long bookId) {

	   model.addAttribute("book", bookService.getBook(bookId));

       return "bookDetail";
   }
   
}
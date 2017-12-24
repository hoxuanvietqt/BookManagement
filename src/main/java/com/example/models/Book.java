package com.example.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "book" )
public class Book {
	 
    @Id
    @GeneratedValue
    @Column(name = "bookId", nullable = false)
    private Long bookId;
    
    @NotEmpty(message = "{error.book.title.empty}")
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty(message = "{error.book.author.empty}")
    @Column(name = "author", nullable = false)
    private String author;
    
    @Column(name = "description", nullable = true)
    private String description;
    
    @Column(name = "created_at", nullable = true)
    private Date createdAt;
    
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

 
}
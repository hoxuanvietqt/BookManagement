package com.example.models;

import javax.validation.constraints.Min;

public class SearchCriteria {

    String bookTitle;

    @Min(value = 0, message = "the number of page is invalid")
    int pageNumber;

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}
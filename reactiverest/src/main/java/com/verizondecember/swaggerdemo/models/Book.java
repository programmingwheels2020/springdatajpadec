package com.verizondecember.swaggerdemo.models;

public class Book {
	private String author;
	private String title;
	private String language;
	private String bookCoverPhoto;
	private Double price;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBookCoverPhoto() {
		return bookCoverPhoto;
	}

	public void setBookCoverPhoto(String bookCoverPhoto) {
		this.bookCoverPhoto = bookCoverPhoto;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", language=" + language + ", bookCoverPhoto="
				+ bookCoverPhoto + ", price=" + price + "]";
	}
  
}

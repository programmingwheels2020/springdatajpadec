package com.example.springdatajpademo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springdatajpademo.models.Book;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	RestTemplate restTemplate;
	
	String URL = "https://615425f02473940017efac40.mockapi.io/books";

	
	@GetMapping("/books")
	public Book[] getBooks(){
		System.out.println(restTemplate);
		
		Book[] books =  this.restTemplate.getForObject(URL, Book[].class);
		
		return books;
	}
	
	@GetMapping("/books/{id}")
	public Book getBooksById(@PathVariable String id){
		System.out.println(restTemplate);
		Map<String,String> param = new HashMap<String, String>();
		param.put("id", id);
		Book book =  this.restTemplate.getForObject(URL+"/{id}", Book.class,param);
		
		
		return book;
	}
	
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		 ResponseEntity<Book> postForEntity = this.restTemplate.postForEntity(URL, book, Book.class);
		 return postForEntity.getBody();
	}
}

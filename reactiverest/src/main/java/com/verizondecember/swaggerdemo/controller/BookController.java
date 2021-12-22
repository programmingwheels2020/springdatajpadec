package com.verizondecember.swaggerdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.verizondecember.swaggerdemo.models.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {
	
	private String URL="https://615425f02473940017efac40.mockapi.io/books";
	
	@Autowired
	WebClient webClient;
	
	@GetMapping("/books")
	public Flux<Book> getBooks(){
		return webClient.get()
				.uri(URL)
				.retrieve()
				.bodyToFlux(Book.class);
	}
	
	@PostMapping("/books")
	public Mono<Book> createBook(@RequestBody Book book){
		return webClient.post()
				.uri(URL)
				.body(Mono.just(book),Book.class)
				.retrieve()
				.bodyToMono(Book.class);
				
		
	}

}

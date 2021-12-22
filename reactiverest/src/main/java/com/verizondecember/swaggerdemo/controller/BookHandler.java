package com.verizondecember.swaggerdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.verizondecember.swaggerdemo.models.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BookHandler {

	public Mono<ServerResponse> getBooks(ServerRequest request){
		Book book = new Book();
		book.setAuthor("Lenin Lawrence");
		book.setTitle("My Autobiography");
		book.setLanguage("English");
		book.setPrice(100.00);
		book.setBookCoverPhoto("http://hello.com");
		/*return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(Mono.just(book),Book.class);
	    */
		
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(book),Book.class);
	
	}
}


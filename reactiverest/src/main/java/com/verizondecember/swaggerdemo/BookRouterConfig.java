package com.verizondecember.swaggerdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.verizondecember.swaggerdemo.controller.BookHandler;

@Configuration
@EnableWebFlux
public class BookRouterConfig {
  
	@Bean
	public RouterFunction<ServerResponse> bookRoute(BookHandler bookHandler){
		//return RouterFunctions
		//		.route(RequestPredicates.GET("/reactive-books"), bookHandler::getBooks);
		
	    return RouterFunctions.route()
	    		.GET("/reactive-books",bookHandler::getBooks)
	    		.build();
	    
	}
}

package com.verizonreactive.reactorcoredemo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Mono<Integer> firstMono = Mono.just(30);
        //firstMono.log().subscribe(System.out::println);
    	
    	Flux<Integer> firstFlux = Flux.just(2,4,6,8,10,12,14,16);
    	
    	firstFlux.log().subscribe(System.out::println);
    	
    }
}

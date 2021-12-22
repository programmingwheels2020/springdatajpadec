package com.verizondecember.swaggerdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verizondecember.swaggerdemo.models.Player;
import com.verizondecember.swaggerdemo.repositories.PlayerRepositories;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlayerController {
	
	
	@Autowired
	private PlayerRepositories playerRepository;
	
	@GetMapping("/players")
	public Flux<Player> getPlayers() {
		return this.playerRepository.findAll();
	}
	
	@PostMapping("/players")
	public Mono<Player> createPlayers(@RequestBody Player player){
		return this.playerRepository.save(player);
	}
	

}

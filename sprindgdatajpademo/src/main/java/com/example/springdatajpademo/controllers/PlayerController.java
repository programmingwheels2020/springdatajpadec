package com.example.springdatajpademo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpademo.models.Player;
import com.example.springdatajpademo.services.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerController {

	@Autowired
	private PlayerService pService;
   
	@PostMapping("/players")
	public Player AddPlayer(@RequestBody Player player) {
		return pService.createPlayer(player);
	}
	
	@GetMapping("/players")
	public List<Player> getPlayers(){
		return pService.getPlayer();
	}
	
	@GetMapping("/players/{id}")
	public Player getPlayersById(@PathVariable String id){
		return pService.getPlayerById(id).get();
	}
	@PutMapping("/players/{id}")
	public Player updatedPlayer(@PathVariable String id, @RequestBody Player player) {
		player.setId(UUID.fromString(id));
		return pService.updatePlayer(player);
	}
	
	@DeleteMapping("/players/{id}")
	public void deletePlayer(@PathVariable String id) {
		
		pService.deletePlayer(id);
	}
	
	@GetMapping("/players/country/{country}")
	public List<Player> getPlayersByCountry(@PathVariable String country) {
		return pService.getPlayersByCountry(country);
	}
	
}

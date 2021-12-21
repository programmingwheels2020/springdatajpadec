package com.example.springdatajpademo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpademo.models.Player;
import com.example.springdatajpademo.repositories.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository pRepository;
	
	public Player createPlayer(Player player) {
		player.setId(UUID.randomUUID());
		
	    pRepository.save(player);
		return player;
	}

	public List<Player> getPlayer() {
		return pRepository.findAll();
	}

	public Optional<Player> getPlayerById(String id) {
		
		return pRepository.findById(UUID.fromString(id));
	}
	
	public Player updatePlayer(Player player) {
		
	    pRepository.save(player);
		return player;
	}

	public void deletePlayer(String id) {
		pRepository.deleteById(UUID.fromString(id));
	}

	public List<Player> getPlayersByCountry(String country) {
		return pRepository.findByCountry(country);
	}

}

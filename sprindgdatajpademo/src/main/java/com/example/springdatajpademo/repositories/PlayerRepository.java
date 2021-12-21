package com.example.springdatajpademo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpademo.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
   List<Player> findByCountry(String country);
}

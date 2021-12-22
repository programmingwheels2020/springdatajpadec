package com.verizondecember.swaggerdemo.repositories;

import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.verizondecember.swaggerdemo.models.Player;

public interface PlayerRepositories extends ReactiveMongoRepository<Player, String>{

}

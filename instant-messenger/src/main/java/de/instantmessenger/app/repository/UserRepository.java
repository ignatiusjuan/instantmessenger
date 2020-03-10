package de.instantmessenger.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.instantmessenger.app.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}

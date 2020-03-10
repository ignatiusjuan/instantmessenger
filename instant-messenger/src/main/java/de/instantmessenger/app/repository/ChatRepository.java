package de.instantmessenger.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.instantmessenger.app.model.Chat;

public interface ChatRepository extends MongoRepository<Chat, String> {

}

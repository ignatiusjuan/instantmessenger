package de.instantmessenger.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document (collection = "chats")
public class Chat {

}

package de.instantmessenger.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "users")
public class User {
	
	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private String eMailAddress;
	private String password;
	
	public User(String firstName, String lastName, String eMailAddress, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMailAddress = eMailAddress;
		this.password = password;
	}
}

package de.instantmessenger.app.service.interfaces;

import de.instantmessenger.app.model.User;

public interface UserService {
	public User signUp(User user);
	public User signIn(User user);
}

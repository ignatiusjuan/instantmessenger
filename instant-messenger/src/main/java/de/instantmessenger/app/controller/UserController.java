package de.instantmessenger.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.instantmessenger.app.model.User;
import de.instantmessenger.app.repository.UserRepository;

// Muss noch ggfs. umgeschrieben werden mithilfe von WebFlux (Reactive programming)
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/all")
	public List<User> getAll() {
		List<User> users = this.userRepository.findAll();
		return users;
	}
	
	@PutMapping
	public void insert(@RequestBody User user) {
		this.userRepository.insert(user);
	}
	
	@PostMapping
	public void update(@RequestBody User user) {
		this.userRepository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.userRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable("id") String id) {
		Optional<User> user = this.userRepository.findById(id);
		return user;
	}	
}

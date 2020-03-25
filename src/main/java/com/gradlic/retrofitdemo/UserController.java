package com.gradlic.retrofitdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("users")
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@GetMapping("users")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping("users/{id}")
	public User getUserById(@PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		
		return optional.get();
		
	}
	
	@PutMapping("users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		
		user.setId(optional.get().getId());
		
		userRepository.save(user);
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		
	}
}

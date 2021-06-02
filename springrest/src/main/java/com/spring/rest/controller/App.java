package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.Users;
import com.spring.rest.service.UserServiceImpl;

@RestController
public class App {
	@Autowired
	UserServiceImpl users;

	@GetMapping("/")
	public String home() {
		
		return "this is home page";
	}
	@GetMapping("/users")
	public List<Users> getUsersList(){
		return users.getUsers();
	}
	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable int id) {
		return users.getUserById(id);
	}
	@PostMapping("/users")
	public Users addUser(@RequestBody Users user) {
		return users.addUser(user);
	}
	@PutMapping("/users/{id}")
	
	
	public Users updateUser(@RequestBody Users user,@PathVariable int id) {
		return users.updateUser(user, id);
	}
	@DeleteMapping("/users")
	public String deleteAll() {
		return users.deleteAll();
	}
	@DeleteMapping("/users/{id}")
	public String deleteById(@PathVariable int id) {
		return users.deleteById(id);
	}
}

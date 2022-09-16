package com.cs.commandos.controller;

import com.cs.commandos.model.User;
import com.cs.commandos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/user")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

	@DeleteMapping(path = { "/user/{id}" })
	public User deleteUser(@PathVariable("id") long id) {
		User user = userService.deleteUser(id);
		return user;
	}

}
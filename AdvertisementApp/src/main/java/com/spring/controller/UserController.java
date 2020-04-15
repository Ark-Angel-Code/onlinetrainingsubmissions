package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.User;
import com.spring.service.UserService;

@RestController
@RequestMapping("/myapp")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value="id") String userId) {
		return userService.getUserById(userId);
	}

	@PostMapping(value="/user", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User registerUser(@RequestBody User user) {
		return userService.save(user); 
	}
	@PostMapping(value="/user/login", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestBody User user) {
		return userService.login(user); 
	}
	
	@PostMapping(value="/user/logout", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestHeader(name="auth-token") String authToken) {
		return userService.logout(authToken); 
	}

	@PutMapping(value="/user/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody User user, @PathVariable(value="id") String id) {
		return userService.update(user, id);
	}

	@DeleteMapping(value="/user/{id}")
	public boolean deleteUser(@PathVariable(value="id") String id) {
		return userService.delete(id);
	}

	@GetMapping("/user/info")
	public String getUsersInfo(@RequestHeader(name="auth-token") String authToken) {
		return userService.getUsersInfo(authToken);
	}

	@GetMapping("/user/firstname/{firstName}")
	public List<User> getUsersByFirstName(@PathVariable(value="firstName") String firstName) {
		return userService.getUsersByFirstName(firstName);
	}

	@GetMapping("/user/firstname/sort/asc")
	public List<User> getUsersByOrderByFirstNameAsc() {
		return userService.getUsersByOrderByFirstNameAsc();
	}
	@GetMapping("/user/firstname/sort/desc")
	public List<User> getUsersByOrderByFirstNameDesc() {
		return userService.getUsersByOrderByFirstNameDesc();
	}
}

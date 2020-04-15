package com.spring.service;

import java.util.List;

import com.spring.json.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User getUserById(String id);
	
	public List<User> getUsersByFirstName(String firstName);
	
	public User save(User user);
	
	public User update(User user, String id);
	
	public String login(User user);
	public String logout(String authToken);
	
	public boolean delete(String id);
	
	public List<User> getUsersByOrderByFirstNameAsc();
	public List<User> getUsersByOrderByFirstNameDesc();

	public String getUsersInfo(String authToken);

	
}

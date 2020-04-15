package com.spring.json;

public class User {

	private long id;
	private String userName;
	private String firstName;
	private String password;
	private String sessionID;

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public User(String userName, String firstName, String password) {
		this.userName = userName;
		this.firstName = firstName;;
		this.password = password;
	}

	public User(long id, String userName, String firstName, String password) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;;
		this.password = password;
	}

	public User() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return id + "\t" + firstName + "\t" + userName + "\t" + password;
	}
}

package com.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS_MASTER")
public class UserEntity {

	@GeneratedValue
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name ="SessionID")
	private String sessionID;
	
	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private List<AdvertisementEntity> advertiseList;
	

	public List<AdvertisementEntity> getAdvertiseList() {
		return advertiseList;
	}

	public void setAdvertiseList(List<AdvertisementEntity> advertiseList) {
		this.advertiseList = advertiseList;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity(String userName, String firstName, String password) {
		this.userName = userName;
		this.firstName = firstName;;
		this.password = password;
	}

	public UserEntity() {
		
	}
	
	public long getId() {
		return id;
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
		return firstName + "\t" + userName + "\t" + password;
	}
}

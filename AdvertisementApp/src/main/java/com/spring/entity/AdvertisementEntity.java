package com.spring.entity;

import java.time.LocalDate;
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
@Table(name="ADVERTISE_MASTER")
public class AdvertisementEntity
{
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Category")
	private String category;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Post_id")
	private String postid;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Date")
	private LocalDate date;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Advertise_ID")
	private List<MessageEntity> messageList;
	

	public List<MessageEntity> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<MessageEntity> messageList) {
		this.messageList = messageList;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Column(name="SEARCH_TEXT")
	private String searchText;
	public AdvertisementEntity()
	{
		super();
	}
	 
	public AdvertisementEntity(String title, String name, String category, String description, String postid, String status , String searchText) 
	{
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
		this.status = status; 
		this.searchText = searchText;
	}
	public AdvertisementEntity(String title, String name, String category, String description, String postid, String status , String searchText, LocalDate date) 
	{
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
		this.status = status; 
		this.date=date;
		this.searchText = searchText;
	}
	 
	public AdvertisementEntity(int id,String title, String name, String category, String description, String postid, String status , String searchText, LocalDate date) 
	{
		super();
		this.id=id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
		this.status = status; 
		this.date=date;
		this.searchText = searchText;
	}
			
	
	
	public AdvertisementEntity(String title, String name, String category, String description) 
	{
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}
	public AdvertisementEntity(String title, String name, String category, String description, String postid) 
	{
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
	}
	public AdvertisementEntity(String title, String name, String category, String description, String postid,
			String status) 
	{
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
		this.status = status;
	}
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
 

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", title=" + title + ", name=" + name + ", category=" + category
				+ ", description=" + description + ", postid=" + postid + ", status=" + status  
				+ ", searchText=" + searchText + "]";
	}

}

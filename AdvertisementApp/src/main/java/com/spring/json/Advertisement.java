package com.spring.json;

import java.time.LocalDate;

public class Advertisement {
	private int id;
	private String title;
	private String name;
	private String category;
	private String description;
	private String postid;
	private String status;
	private String searchText;
	private LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Advertisement()
	{
		super();
	}
		
	public Advertisement(String title, String name, String category, String description, String postid, String status, String searchText) 
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
	public Advertisement(String title, String name, String category, String description, String postid, String status, String searchText, LocalDate date) 
	{
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
		this.status = status;
		this.searchText = searchText;
		this.date=date;
	}
	
	public Advertisement(int id,String title, String name, String category, String description, String postid, String status , String searchText, LocalDate date) 
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
			
	public Advertisement(String title, String category, String description, String status, String searchText) 
	{
		super();
		this.title = title;
		this.category = category;
		this.description = description;
		this.status = status;
		this.searchText = searchText;
	}

	public Advertisement(int id,String title, String name, String category, String description) 
	{
		super();
		this.id=id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}
	public Advertisement(int id,String title, String name, String category, String description, String postid) 
	{
		super();
		this.id=id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
	}
	public Advertisement(int id, String title, String name, String category, String description, String postid,
			String status) 
	{
		super();
		this.id=id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
		this.status = status;
	}
	public Advertisement(int id, String title, String name, String category, String description, String postid,
			String status, String searchText) 
	{
		super();
		this.id=id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
		this.status = status;
		this.searchText=searchText;
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
	public boolean equals(Object obj) 
	{
		Advertisement advert = (Advertisement) obj;
		if (this.postid.equals(advert.postid))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", title=" + title + ", name=" + name + ", category=" + category
				+ ", description=" + description + ", postid=" + postid + ", status=" + status  
				+ ", searchText=" + searchText + "]";
	}

	
}

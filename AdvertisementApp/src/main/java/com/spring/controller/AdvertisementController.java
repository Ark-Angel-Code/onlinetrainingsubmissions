package com.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.MessageEntity;
import com.spring.json.Advertisement;
import com.spring.service.AdvertisementService;

@RestController
@RequestMapping("/myapp")
public class AdvertisementController 
{
	@Autowired
	private AdvertisementService microService;
	
	@PostMapping(value="/advertisement", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object  postAdvertise(@RequestBody Advertisement advertisement,@RequestHeader(name="auth-token") String authToken)
	{
		return microService.save(advertisement,authToken);
	}
	
	@PostMapping(value="/advertisement/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object  updateAdvertise(@RequestBody Advertisement advertisement,@RequestHeader(name="auth-token") String authToken,@PathVariable(value="id") String id)
	{
	  return microService.update(advertisement,authToken,id);
	}
	
	@GetMapping("/advertisement/user")
	public List<Advertisement> getAdvertisementBySessionId(@RequestHeader(name="auth-token") String authToken) {
		return microService.getAdvertisementBySessionId(authToken);
	}
	
	@GetMapping("/advertisement/user/{postid}")
	public List<Advertisement> getAdvertiseByPostId(@RequestHeader(name="auth-token") String authToken,@PathVariable(value="postid") String postid) {
		return microService.getAdvertisementByPostId(authToken,postid);
	}
	
	@DeleteMapping("/advertisement/user/{postid}")
	public boolean deleteAdvertiseByPostId(@RequestHeader(name="auth-token") String authToken,@PathVariable(value="postid") String postid) {
		return microService.deleteAdvertisementByPostId(authToken,postid);
	}
	
	@GetMapping("/advertisement/searchText/{searchText}")
	public List<Advertisement> getAdvertisementBySearchText(@PathVariable(value="searchText") String searchText)
	{ 
		return microService.getAdvertisementBySearchText(searchText);
	}
	
	@GetMapping("/advertisement/category/{category}")
	public List<Advertisement> getAdvertisementByCategory(@PathVariable(value="category") String category)
	{
		return microService.getAdvertisementByCategory(category);
	}
	
	@GetMapping("/advertisement/postedBy/{name}")
	public List<Advertisement> getAdvertisementByName(@PathVariable(value="name") String name)
	{
		return microService.getAdvertisementByName(name);
	}
	
	@GetMapping("/advertisement/PostId/{postid}")
	public Advertisement getAdvertisementByPostId(@PathVariable(value="postid") String postid)
	{
		return microService.getAdvertisementByPostId(postid);
	}
	
	@GetMapping("/advertisement/{date}")
	@DateTimeFormat(iso=ISO.DATE)
	public List<Advertisement> getAdvertisementOnDate(@PathVariable(value="date") @DateTimeFormat(iso=ISO.DATE) LocalDate date)
	{
		return microService.getAdvertisementOnDate(date);
	}
	
	@GetMapping("/advertisement/category")
	public List<String> getAllCategory()
	{
		return microService.getAllCategory();
	}
	
	@GetMapping("/advertisementList")
	public List<Advertisement> getAllAdvertisement()
	{
		return microService.getAllAdvertisement();
	}
	
	@GetMapping("/advertisement/fromDate/{date}")
	public List<Advertisement> getAdvertisementFromDate(@PathVariable(value="date") @DateTimeFormat(iso = ISO.DATE) LocalDate date)
	{
		return microService.getAllAdvertisementFromDate(date);
	}
	
	@GetMapping("/advertisement/betweenDate")
	public List<Advertisement> getAdvertisementBetweenDates(@RequestParam(value="startDate") @DateTimeFormat(iso = ISO.DATE) LocalDate startDate,
												        	@RequestParam(value="endDate") @DateTimeFormat(iso = ISO.DATE) LocalDate endDate)
	{
		return microService.getAllAdvertisementBetweenDates(startDate,endDate);
	}
	
	@GetMapping("/advertisement/sortByTitle")
	public List<Advertisement> getAdvertisementSortByTitle()
	{
		return microService.getAllAdvertisementSortByTitle();
	}
	
	@GetMapping("/advertisement/sortByDscTitle")
	public List<Advertisement> getAdvertisementSortByDscTitle()
	{
		return microService.getAllAdvertisementSortByDescTitle();
	}
	
	@GetMapping("/advertisement/sortByPostId")
	public List<Advertisement> getAdvertisementSortByPostId()
	{
		return microService.getAllAdvertisementSortByPostId();
	}
	
	@GetMapping("/advertisement/sortByDscPostId")
	public List<Advertisement> getAdvertisementSortByDscPostId()
	{
		return microService.getAllAdvertisementSortByDescPostId();
	}
	
	@GetMapping("/advertisement/sortByPostedBy")
	public List<Advertisement> getAdvertisementSortByPostedBy()
	{
		return microService.getAllAdvertisementSortByPostedBy();
	}
	
	@GetMapping("/advertisement/sortByDscPostedBy")
	public List<Advertisement> getAdvertisementSortByDscPostedBy()
	{
		return microService.getAllAdvertisementSortByDescPostedBy();
	}
	
	@PostMapping(value="advertisement/{postid}/addMessage", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public MessageEntity addMessage(@RequestBody MessageEntity message,@PathVariable(value="postid") String postid )
	{
		return microService.addMessage(message,postid);
	}
		
}

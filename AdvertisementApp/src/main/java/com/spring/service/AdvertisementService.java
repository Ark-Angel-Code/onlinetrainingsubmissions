package com.spring.service;

import java.time.LocalDate;
import java.util.List;

import com.spring.json.Advertisement;
import com.spring.entity.MessageEntity;

public interface AdvertisementService {

	Object save(Advertisement advertise, String authToken);

	Object update(Advertisement advertise, String authToken,String id);

	List<Advertisement> getAdvertisementBySessionId(String authToken);

	List<Advertisement> getAdvertisementByPostId(String authToken, String postid);

	boolean deleteAdvertisementByPostId(String authToken, String postid);

	List<Advertisement> getAdvertisementBySearchText(String searchText);

	List<Advertisement> getAdvertisementByCategory(String category);

	List<Advertisement> getAdvertisementByName(String name);

	Advertisement getAdvertisementByPostId(String postid);

	List<Advertisement> getAdvertisementOnDate(LocalDate date);
	
	List<String> getAllCategory();

	List<Advertisement> getAllAdvertisement();

	List<Advertisement> getAllAdvertisementFromDate(LocalDate date);

	List<Advertisement> getAllAdvertisementToDate(LocalDate date);

	List<Advertisement> getAllAdvertisementBetweenDates(LocalDate startDate, LocalDate endDate);

	List<Advertisement> getAllAdvertisementSortByTitle();

	List<Advertisement> getAllAdvertisementSortByDescTitle();
	
	List<Advertisement> getAllAdvertisementSortByPostId();

	List<Advertisement> getAllAdvertisementSortByDescPostId();

	List<Advertisement> getAllAdvertisementSortByDescPostedBy();

	List<Advertisement> getAllAdvertisementSortByPostedBy();

	MessageEntity addMessage(MessageEntity message , String postid);


	 

}

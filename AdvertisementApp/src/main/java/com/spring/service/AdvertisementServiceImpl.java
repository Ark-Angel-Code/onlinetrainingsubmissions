package com.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.AdvertisementEntity;
import com.spring.entity.MessageEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Advertisement;
import com.spring.rest.repository.AdvertisementRepository;
import com.spring.rest.repository.MessageRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.AdvertisementUtils;

@Service
public class AdvertisementServiceImpl implements AdvertisementService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdvertisementRepository advertisementRepository;

	@Autowired
	private MessageRepository messageRepository;
	
	
	@Override
	public Object save(Advertisement advertisement, String authToken)
	{
		
		List<UserEntity> userList=userRepository.findBySessionID(authToken);
		if (userList!=null)
		{
			String postid = new java.rmi.server.UID().toString().substring(0, 5);
			advertisement.setPostid(postid); 
			LocalDate date = LocalDate.now();
			advertisement.setDate(date);
			advertisement.setName(userList.get(0).getFirstName());
			AdvertisementEntity advertisementEntity= advertisementRepository.save(AdvertisementUtils.convertAdvertisementToAdvertisementEntity(advertisement));
			return AdvertisementUtils.convertAdvertisementEntityToAdvertisement(advertisementEntity);
		}
		else 
		{
			return "{\"result\": \"failure\", \"message\": \"Wrong Sessionid\"}";
		}
			
	}

	@Override
	public Object update(Advertisement advertisement, String authToken,String id) {
		List<UserEntity> userList=userRepository.findBySessionID(authToken);
		if (userList!=null)
		{
			AdvertisementEntity advertisementEntity=advertisementRepository.findById(Long.valueOf(id)).get();
			if(advertisementEntity != null) 
			{
				advertisementEntity.setTitle(advertisement.getTitle());
				advertisementEntity.setName(advertisement.getName());
				advertisementEntity.setDescription(advertisement.getDescription());
				advertisementEntity.setCategory(advertisement.getCategory());
				advertisementEntity.setStatus(advertisement.getStatus());
				advertisementEntity.setSearchText(advertisement.getSearchText());
				advertisementEntity=advertisementRepository.save(advertisementEntity);
				return AdvertisementUtils.convertAdvertisementEntityToAdvertisement(advertisementEntity);
			}
			else
				return "{\"result\": \"failure\",\"message\": \"Wrong Advertiseid\"}";
			
		}
		else 
		{
			return "{\"Result\": \"Failure\",\"Message\": \"Wrong Sessionid\"}";
		}
	}

	@Override
	public List<Advertisement> getAdvertisementBySessionId(String authToken) {
		String userName=userRepository.findBySessionID(authToken).get(0).getFirstName();
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList( advertisementRepository.findByName(userName));
	}

	@Override
	public List<Advertisement> getAdvertisementByPostId(String authToken, String postid) 
	{
		String userName=userRepository.findBySessionID(authToken).get(0).getFirstName();
		List<Advertisement> advertisementByFirstName=AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList( advertisementRepository.findByName(userName));
		List<Advertisement> advertisement=advertisementByFirstName.stream().filter(advertise -> postid.equals(advertise.getPostid())).collect(Collectors.toList());
		return advertisement;
	}

	@Override
	@Transactional
	public boolean deleteAdvertisementByPostId(String authToken, String postid) {
		String userName=userRepository.findBySessionID(authToken).get(0).getFirstName();
		List<Advertisement> advertisementByFirstName=AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList( advertisementRepository.findByName(userName));
		Advertisement advertisement = AdvertisementUtils.convertAdvertisementEntityToAdvertisement(advertisementRepository.findByPostid(postid));
		if (advertisementByFirstName.contains(advertisement))
		{
			advertisementRepository.deleteByPostid(postid);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Advertisement> getAdvertisementBySearchText(String searchText) 
	{
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findBySearchText(searchText));
	
	}

	@Override
	public List<Advertisement> getAdvertisementByCategory(String category) {
		
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByCategory(category));
	}

	@Override
	public List<Advertisement> getAdvertisementByName(String name) {
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByName(name));
	}

	@Override
	public Advertisement getAdvertisementByPostId(String postid) {
		
		return AdvertisementUtils.convertAdvertisementEntityToAdvertisement(
				advertisementRepository.findByPostid(postid));
	}

	@Override
	public List<Advertisement> getAdvertisementOnDate(LocalDate date) {
	
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByDate(date));
	}
	
	@Override
	public List<String> getAllCategory() {
		
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findAll()).stream().
				map(Advertisement :: getCategory).distinct().collect(Collectors.toList());
	}
	
	@Override
	public List<Advertisement> getAllAdvertisement() {
		
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findAll());
	}

	@Override
	public List<Advertisement> getAllAdvertisementFromDate(LocalDate date) {
		 
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByDateGreaterThanEqual(date));
	}

	@Override
	public List<Advertisement> getAllAdvertisementToDate(LocalDate date) {
		
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByDateLessThanEqual(date));
	}

	@Override
	public List<Advertisement> getAllAdvertisementBetweenDates(LocalDate startDate, LocalDate endDate) {
		 
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByDateGreaterThanEqualAndDateLessThanEqual(startDate,endDate));
	}

	@Override
	public List<Advertisement> getAllAdvertisementSortByTitle() {
		 
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByOrderByTitleAsc());
	}
	@Override
	public List<Advertisement> getAllAdvertisementSortByDescTitle() {
		 
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByOrderByTitleDesc());
	}
	@Override
	public List<Advertisement> getAllAdvertisementSortByPostId() {
		 
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByOrderByPostidAsc());
	}
	@Override
	public List<Advertisement> getAllAdvertisementSortByDescPostId() {
		 
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByOrderByPostidDesc());
	}
	@Override
	public List<Advertisement> getAllAdvertisementSortByPostedBy() {
		 
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByOrderByNameAsc());
	}
	@Override
	public List<Advertisement> getAllAdvertisementSortByDescPostedBy() {
		 
		return AdvertisementUtils.convertAdvertisementEntityListToAdvertisementList(
				advertisementRepository.findByOrderByNameDesc());
	}

	@Override
	public MessageEntity addMessage(MessageEntity message,String postid) 
	{
		 AdvertisementEntity advertiseEntity= advertisementRepository.findByPostid(postid);
		 if(advertiseEntity!=null)
		 {
			 List<MessageEntity> messageList=advertiseEntity.getMessageList();
			 message.setPostId(postid);
			 messageList.add(message);
			 message=messageRepository.save(message);
			 return message;
		 }
		return null;
	}


}

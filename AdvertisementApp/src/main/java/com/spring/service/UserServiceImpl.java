package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.UserEntity;
import com.spring.json.User;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		UserEntity userEntity = userRepository.save(UserUtils.convertUserToUserEntity(user));
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	public List<User> getAllUsers() {
		List<UserEntity> userEntityList = userRepository.findAll();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	public User getUserById(String id) {
		UserEntity userEntity = userRepository.findById(Long.valueOf(id)).get();
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		List<UserEntity> userEntityList = userRepository.findByFirstName(firstName);
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public User update(User user, String id) {
		UserEntity userEntity = userRepository.findById(Long.valueOf(id)).get();
		if(userEntity != null) {
			userEntity.setFirstName(user.getFirstName());
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity = userRepository.save(userEntity);
			return UserUtils.convertUserEntityToUser(userEntity);
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		if(userRepository.existsById(Long.valueOf(id))) {
			userRepository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}

	@Override
	public List<User> getUsersByOrderByFirstNameAsc() {
		List<UserEntity> userEntityList = userRepository.findByOrderByFirstNameAsc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public List<User> getUsersByOrderByFirstNameDesc() {
		List<UserEntity> userEntityList = userRepository.findByOrderByFirstNameDesc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public String login(User user) {
		String name= user.getUserName();
		String password=user.getPassword();
		List<UserEntity> userList=userRepository.findByUserName(name);
		if(userList==null || userList.size()==0)
		{
			return "failed";
		}
		else {
			UserEntity userEntity=userList.get(0);
			String sessionID=new java.rmi.server.UID().toString().substring(0,10);
			userEntity.setSessionID(sessionID);
			userRepository.save(userEntity);
			return "sessionID:"+sessionID;
		}
	}
		@Override
		public String logout(String authToken) {
			List<UserEntity> userList=userRepository.findBySessionID(authToken);
			if(userList==null || userList.size()==0)
			{
				return "failed";
			}
			else
			{
				UserEntity userEntity=userList.get(0);
				String sessionID=null;
				userEntity.setSessionID(sessionID);
				userRepository.save(userEntity);
				return "Logged out successfully";
			}
			
		
	}

		@Override
		public String getUsersInfo(String authToken) {
			List<UserEntity> userList=userRepository.findBySessionID(authToken);
			if(userList==null || userList.size()==0)
			{
				return "failed";
			}
			else
			{
				UserEntity userEntity=userList.get(0);
				return userEntity.toString();
			}
		}

}

package com.poc.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.User;
import com.poc.repositories.UserRepository;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUser() {
		try {
			LOGGER.info("getting users");
			List<User> users = userRepository.findAll();
			return users;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	public List<User> getUsersOrderByDob() {
		try {
			LOGGER.info("getting user order by date of birth");
			List<User> users = userRepository.findAllByOrderByDobAsc();
			return users;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}

	}

	public List<User> getUsersOrderByDoj() {
		try {
			LOGGER.info("getting user order by date of joining");
			List<User> users = userRepository.findAllByOrderByDojAsc();
			return users;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}

	}

	public List<User> getUserOrderByDojAndDoj() {
		try {
			LOGGER.info("getting user order by date of birth and date of joining");
			List<User> users = userRepository.findAllByOrderByDobAscDojAsc();
			return users;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
		
	}

	public int softDeleteUser(int user_id) {
		try {
			LOGGER.info("soft deleting user bu user_id");
			userRepository.softDeleteUser(user_id);
			return 1;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 0;
		}
		
	}

	public int hardDeleteUser(int user_id) {
		try {
			LOGGER.info("hard deleting user by user_id");
			userRepository.deleteById(user_id);
			return 1;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return 0;
		}
		
	}

	
}

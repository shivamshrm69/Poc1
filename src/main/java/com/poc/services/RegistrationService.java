package com.poc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.entity.User;
import com.poc.repositories.RegistrationRepository;

@Service
@Transactional
public class RegistrationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);
	@Autowired
	RegistrationRepository registrationRepository;
	
	public boolean saveUserRegistration(User user)
	{
		try {
			LOGGER.info("saving user");
			registrationRepository.save(user);
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
		
	}
}

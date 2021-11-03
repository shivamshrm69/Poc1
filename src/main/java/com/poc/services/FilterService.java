package com.poc.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.entity.User;
import com.poc.repositories.FilterRepository;

@Service
@Transactional
public class FilterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FilterService.class);
	@Autowired
	FilterRepository filterRepository;
	
	public List<User> searchFilter(String value)
	{
		try {
			LOGGER.info("getting filtered users");
			List<User> filteredUsers=filterRepository.filterData(value);
			return filteredUsers;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
		
	}
}

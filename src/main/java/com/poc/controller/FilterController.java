package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poc.entity.User;
import com.poc.response.PocResponse;
import com.poc.services.FilterService;

@RestController
@CrossOrigin
public class FilterController {
	PocResponse response=null;
	
	@Autowired
	FilterService filterService;
	
	@GetMapping("/searchFilter/{inputValue}")
	public PocResponse searchFilter(@PathVariable String inputValue)
	{
		response=new PocResponse();
		List<User> filteredUser= filterService.searchFilter(inputValue);
		if (filteredUser == null) {
			response.getResult().put("error", "Something went wrong");
			response.setSuccess(false);
		} else if (filteredUser.isEmpty()) {
			response.getResult().put("success", "No User Available");
			response.setSuccess(true);
		} else {
			response.getResult().put("success", filteredUser);
			response.setSuccess(true);
		}
		return response; 
	}
}

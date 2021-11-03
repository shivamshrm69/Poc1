package com.poc.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.entity.User;
import com.poc.response.PocResponse;
import com.poc.services.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

	PocResponse response=null;

	@PostMapping("/registration")
	public PocResponse user(@Valid @RequestBody User user, BindingResult result) {
		response = new PocResponse();
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			Set<String> errorMessages = new HashSet<String>();
			for (FieldError error : errors) {
				LOGGER.error(error.getDefaultMessage());
				errorMessages.add(error.getDefaultMessage());
			}
			response.getResult().put("error", errorMessages);
			response.setSuccess(false);
			return response;
		}

		boolean isDone = registrationService.saveUserRegistration(user);
		if (isDone == true) {
			response.getResult().put("success", "Registration Successful");
			response.setSuccess(true);
		} else {
			response.getResult().put("error", "Something went wrongl");
			response.setSuccess(false);
		}
		return response;
	}

	@PutMapping("/userEdit")
	public PocResponse userEdit(@Valid @RequestBody User user, BindingResult result) {
		response=new PocResponse();
		boolean isDone = registrationService.saveUserRegistration(user);
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			Set<String> errorMessages = new HashSet<String>();
			for (FieldError error : errors) {
				LOGGER.error(error.getDefaultMessage());
				errorMessages.add(error.getDefaultMessage());
			}
			response.getResult().put("error", errorMessages);
			response.setSuccess(false);
			return response;
		}
		if (isDone == true) {
			response.getResult().put("success", "Updated Successfully");
			response.setSuccess(true);
		} else {
			response.getResult().put("error", "Something went wrongl");
			response.setSuccess(false);
		}
		return response;
	
	}
}

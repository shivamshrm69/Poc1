package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.entity.User;
import com.poc.response.PocResponse;
import com.poc.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	PocResponse response=null;

	@GetMapping("/allUsers")
	public PocResponse users() {
		response = new PocResponse();
		List<User> users = userService.getAllUser();
		if (users == null) {
			response.getResult().put("error", "Something went wrong");
			response.setSuccess(false);
		} else if (users.isEmpty()) {
			response.getResult().put("success", "No User Available");
			response.setSuccess(true);
		} else {
			response.getResult().put("success", users);
			response.setSuccess(true);
		}
		return response;
	}

	@GetMapping("/usersOrderByDob")
	public PocResponse usersOrderByDob() {
		response = new PocResponse();
		List<User> users = userService.getUsersOrderByDob();
		if (users == null) {
			response.getResult().put("error", "Something went wrong");
			response.setSuccess(false);
		} else if (users.isEmpty()) {
			response.getResult().put("success", "No User Available");
			response.setSuccess(true);
		} else {
			response.getResult().put("success", users);
			response.setSuccess(true);
		}
		return response;
	}

	@GetMapping("/usersOrderByDoj")
	public PocResponse usersOrderByDoj() {
		response = new PocResponse();
		List<User> users = userService.getUsersOrderByDoj();
		if (users == null) {
			response.getResult().put("error", "Something went wrong");
			response.setSuccess(false);
		} else if (users.isEmpty()) {
			response.getResult().put("success", "No User Available");
			response.setSuccess(true);
		} else {
			response.getResult().put("success", users);
			response.setSuccess(true);
		}
		return response;
	}

	@GetMapping("/userOrderByDojAndDoj")
	public PocResponse userOrderByDojAndDoj() {
		response = new PocResponse();
		List<User> users = userService.getUserOrderByDojAndDoj();
		if (users == null) {
			response.getResult().put("error", "Something went wrong");
			response.setSuccess(false);
		} else if (users.isEmpty()) {
			response.getResult().put("success", "No User Available");
			response.setSuccess(true);
		} else {
			response.getResult().put("success", users);
			response.setSuccess(true);
		}
		return response;
	}

	@PostMapping("/softDeleteUser/{user_id}")
	public PocResponse softDeleteUser(@PathVariable int user_id) {
		response = new PocResponse();
		int result = userService.softDeleteUser(user_id);
		if (result == 1) {
			response.getResult().put("success", "user with id: " + user_id + " marked as deleted");
			response.setSuccess(true);
		} else {
			response.getResult().put("error", "Something went wrong");
			response.setSuccess(false);
		}
		return response;
	}

	@PostMapping("/hardDeleteUser/{user_id}")
	public PocResponse hardDeleteUser(@PathVariable int user_id) {
		response = new PocResponse();
		int result = userService.hardDeleteUser(user_id);
		if (result == 1) {
			response.getResult().put("success", "user with id: " + user_id + " deleted successfully");
			response.setSuccess(true);
		} else {
			response.getResult().put("error", "Something went wrong");
			response.setSuccess(false);
		}
		return response;
	}
}

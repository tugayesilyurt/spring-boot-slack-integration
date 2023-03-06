package com.slack.integration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slack.integration.request.CreateUserRequest;
import com.slack.integration.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request){
		userService.createUser(request);
		return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.CREATED);
	}
	
}

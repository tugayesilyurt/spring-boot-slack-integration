package com.slack.integration.service;

import org.springframework.stereotype.Service;

import com.slack.integration.request.CreateUserRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final SlackService slackService;
	
	public void createUser(CreateUserRequest request) {
		
		// save the user
		
		// save the user
		
		slackService.sendMessageToSlack("New user created ! : " + request.getName());
		
	}
	
}

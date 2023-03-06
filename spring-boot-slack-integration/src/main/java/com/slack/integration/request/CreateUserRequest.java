package com.slack.integration.request;

import lombok.Data;

@Data
public class CreateUserRequest {

	private String name;
	private String surname;
	private String email;
	private String password;
	
}

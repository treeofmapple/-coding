package com.tom.tcc.backend.grades.dto;

import com.tom.tcc.backend.security.model.User;

public record EvaluationResponse(
		
		String subject, String description, double grade, UserDTO user) {

	public EvaluationResponse(String name, String email, double grade, User user) {
		this (name, email, grade, new UserDTO(user));
	}
	
	public record UserDTO(String name, String email) {
		public UserDTO(User user) {
			this(user.getUsername(), user.getEmail());
		}
	}
	
}

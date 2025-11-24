package com.tom.tcc.backend.grades.mapper;

import org.springframework.stereotype.Service;

import com.tom.tcc.backend.grades.dto.UserRequest;
import com.tom.tcc.backend.grades.dto.UserResponse;
import com.tom.tcc.backend.grades.dto.user.UserGradeResponse;
import com.tom.tcc.backend.grades.dto.user.UserUpdateResponse;
import com.tom.tcc.backend.grades.model.User;

@Service
public class UserMapper {

	public User toUser(UserRequest request) {
		if (request == null) {
			return null;
		}

		return User.builder().name(request.name()).email(request.email()).build();
	}

	public UserResponse fromUser(User user) {
		if (user == null) {
			return null;
		}

		return new UserResponse(user.getName(), user.getEmail(), user.getEvaluations());
	}

	public UserGradeResponse fromUserGrade(String name, double averageGrade) {
		if (name == null) {
			return null;
		}
		return new UserGradeResponse(name, averageGrade);
	}

	public UserUpdateResponse fromUserUpdate(User user) {
		if (user == null) {
			return null;
		}
		return new UserUpdateResponse(user.getName(), user.getEmail());
	}

	public void mergeUser(User user, UserRequest request) {
		user.setName(request.name());
		user.setEmail(request.email());
	}

}

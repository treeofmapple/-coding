package com.tom.tcc.backend.security.dto.user;

import java.time.ZonedDateTime;
import java.util.UUID;

public record UserResponse(
		
		UUID id,
		String username,
		String email,
		Integer age,
		String role,
		ZonedDateTime createdAt
) {

}

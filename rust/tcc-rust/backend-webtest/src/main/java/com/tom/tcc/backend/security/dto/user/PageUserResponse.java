package com.tom.tcc.backend.security.dto.user;

import java.util.List;

public record PageUserResponse(
		
		List<UserResponse> content,
		int page,
		int size,
		long totalPages,
		long totalElements
		
		
		) {

}

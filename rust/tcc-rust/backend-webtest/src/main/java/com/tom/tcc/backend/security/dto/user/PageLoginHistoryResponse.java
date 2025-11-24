package com.tom.tcc.backend.security.dto.user;

import java.util.List;

public record PageLoginHistoryResponse(
		
		List<LoginHistoryResponse> content,
		int page,
		int size,
		long totalPages,
		long totalElements
		
		) {

}

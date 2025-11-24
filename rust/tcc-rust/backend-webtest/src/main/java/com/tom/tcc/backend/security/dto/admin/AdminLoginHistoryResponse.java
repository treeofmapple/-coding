package com.tom.tcc.backend.security.dto.admin;

import java.time.ZonedDateTime;

public record AdminLoginHistoryResponse(
		
		String username,
		String email,
		ZonedDateTime loginTime,
		String ipAddress
		
		) {

}

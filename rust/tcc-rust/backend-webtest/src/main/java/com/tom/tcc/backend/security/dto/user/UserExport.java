package com.tom.tcc.backend.security.dto.user;

import org.springframework.core.io.Resource;

public record UserExport(
		
		Resource resource,
		String fileName,
		int fileSize
		
		) {

}

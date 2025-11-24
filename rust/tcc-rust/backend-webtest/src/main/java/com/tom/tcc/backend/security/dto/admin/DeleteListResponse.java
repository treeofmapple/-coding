package com.tom.tcc.backend.security.dto.admin;

import java.util.List;
import java.util.UUID;

public record DeleteListResponse(
		
	    List<UUID> deletedUserIds
	    
		) {

}

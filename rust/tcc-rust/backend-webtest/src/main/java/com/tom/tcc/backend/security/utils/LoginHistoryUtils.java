package com.tom.tcc.backend.security.utils;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

import com.tom.tcc.backend.security.model.LoginHistory;
import com.tom.tcc.backend.security.model.User;
import com.tom.tcc.backend.security.repository.LoginHistoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoginHistoryUtils {

	private final LoginHistoryRepository repository;
	
	public void storeLoginHistory(User user, String ip) {
		ZonedDateTime time = ZonedDateTime.now();
		
		var login = LoginHistory.builder()
				.user(user)
				.loginTime(time)
				.ipAddress(ip)
				.build();
		
		// Mapstruct is unable to do this
		// var login = mapper.build(user, time, ip);
		repository.save(login);
	}
	
}

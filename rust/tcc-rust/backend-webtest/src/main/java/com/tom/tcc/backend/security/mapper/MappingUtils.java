package com.tom.tcc.backend.security.mapper;

import java.time.ZonedDateTime;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.tom.tcc.backend.security.model.User;
import com.tom.tcc.backend.security.repository.LoginHistoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MappingUtils {

    private final LoginHistoryRepository loginHistoryRepository;

    @Named("getLastLoginTime")
    public ZonedDateTime getLastLoginTime(User user) {
        if (user == null || user.getId() == null) {
            return null;
        }
        return loginHistoryRepository.findFirstByUserIdOrderByLoginTimeDesc(user.getId())
                .map(loginHistory -> loginHistory.getLoginTime())
                .orElse(null);
    }
	
}

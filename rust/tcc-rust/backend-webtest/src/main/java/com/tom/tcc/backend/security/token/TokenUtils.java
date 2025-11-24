package com.tom.tcc.backend.security.token;

import org.springframework.stereotype.Component;

import com.tom.tcc.backend.security.model.Token;
import com.tom.tcc.backend.security.model.User;
import com.tom.tcc.backend.security.repository.TokenRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TokenUtils {

	private final TokenRepository tokenRepository;
	
	public void saveUserToken(User user, String jwtToken) {
		var token = Token.builder()
		        .user(user)
		        .token(jwtToken)
//		        .tokenType(TokenType.BEARER)
		        .expired(false)
		        .revoked(false)
		        .build();
		tokenRepository.save(token);
	}

	public void revokeUserAllTokens(User user) {
		var validTokens = tokenRepository.findAllValidTokensByUserId(user.getId());
		if (validTokens.isEmpty()) {
			return;
		}
		validTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validTokens);
	}
	
}

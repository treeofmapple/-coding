package com.tom.tcc.backend.security.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.tom.tcc.backend.exception.DataViolationException;
import com.tom.tcc.backend.exception.NotFoundException;
import com.tom.tcc.backend.security.model.User;
import com.tom.tcc.backend.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserUtils {

	private final UserRepository repository;

	public User findUserByUserId(UUID userId) {
		return repository.findById(userId).orElseThrow(() -> new NotFoundException("The user id was not found"));
	}

	public User findUserByIdentifier(String identifier) {
		return repository.findByIdentifier(identifier)
				.orElseThrow(() -> new NotFoundException("User username or email not found"));
	}

	public User findUserByIdOrIdentifier(String identifier) {

		if (identifier == null || identifier.isBlank()) {
			throw new IllegalArgumentException("User ID or identifier (username/email) must be provided.");
		}

		try {
			UUID userId = UUID.fromString(identifier);
			return findUserByUserId(userId);
		} catch (IllegalArgumentException e) {
			return findUserByIdentifier(identifier);
		}
	}

	public void ensureUsernameAndEmailAreUnique(String username, String email) {
		if (repository.existsByUsername(username)) {
			throw new DataViolationException("Username is already taken: " + username);
		}

		if (repository.existsByEmail(email)) {
			throw new DataViolationException("Email is already in use: " + email);
		}
	}

	public void checkIfEmailIsTakenByAnotherUser(User currentUser, String newEmail) {
		if (repository.existsByEmailAndIdNot(newEmail, currentUser.getId())) {
			throw new DataViolationException("Email is already in use by another account: " + newEmail);
		}
	}

	public void checkIfUsernameIsTakenByAnotherUser(User currentUser, String newUsername) {
		if (repository.existsByUsernameAndIdNot(newUsername, currentUser.getId())) {
			throw new DataViolationException("Username is already taken by another account: " + newUsername);
		}
	}

}

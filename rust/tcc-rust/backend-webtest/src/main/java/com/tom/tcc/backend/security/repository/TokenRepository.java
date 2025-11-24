package com.tom.tcc.backend.security.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tom.tcc.backend.security.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("""
            SELECT t FROM Token t
            WHERE t.user.id = :userId AND t.expired = false AND t.revoked = false
            """)
    List<Token> findAllValidTokensByUserId(UUID userId);
	
	Optional<Token> findFirstByUserIdOrderByIdDesc(UUID userId);
	
	Optional<Token> findByToken(String token);
}

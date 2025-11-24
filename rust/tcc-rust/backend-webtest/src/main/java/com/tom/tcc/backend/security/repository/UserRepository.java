package com.tom.tcc.backend.security.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tom.tcc.backend.security.model.User;
import com.tom.tcc.backend.security.model.enums.Role;

@Repository
public interface UserRepository extends JpaRepository <User, UUID>, JpaSpecificationExecutor<User> {

    @Query("SELECT u FROM User u WHERE u.username = :identifier OR u.email = :identifier")
    Optional<User> findByIdentifier(@Param("identifier") String identifier);
	
	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

	List<User> findAllByRoleNot(Role role);
	
	List<User> findAllByIdIn(List<UUID> ids);
	
    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);
    
    boolean existsByEmailAndIdNot(String email, UUID id);

    boolean existsByUsernameAndIdNot(String username, UUID id);
    
}

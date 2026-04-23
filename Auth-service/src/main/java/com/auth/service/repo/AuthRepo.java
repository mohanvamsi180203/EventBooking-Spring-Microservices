package com.auth.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.service.entity.Auth;

public interface AuthRepo extends JpaRepository<Auth, Integer>{

	

	    Auth findByEmail(String email);

	    boolean existsByEmail(String email);

	    boolean existsByUsername(String username);
	    
	    
	}


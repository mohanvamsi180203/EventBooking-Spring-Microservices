package com.user.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	 User findByEmail(String email);

	    List<User> findByNameContaining(String name);

	    List<User> findByCity(String city);

	    boolean existsByEmail(String email);
}

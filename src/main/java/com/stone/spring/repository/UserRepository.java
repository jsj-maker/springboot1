package com.stone.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	public List<User> findUserByUsernameContaining(String username) ;

	public List<User> findUserByUserId(Long userId);
}

package com.mas.quotation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mas.quotation.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	Optional<User> findByUsernameOrEmail(String username, String email);
	User findByUsername(String username);
	User findByEmail(String email);
}

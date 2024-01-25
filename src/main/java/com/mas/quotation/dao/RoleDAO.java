package com.mas.quotation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mas.quotation.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(String name);

}

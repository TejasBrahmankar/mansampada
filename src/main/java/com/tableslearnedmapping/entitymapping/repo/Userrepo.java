package com.tableslearnedmapping.entitymapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tableslearnedmapping.entitymapping.entities.User;

public interface Userrepo extends JpaRepository<User, Integer> {

	public User findByEmail(String emaill);
	
}
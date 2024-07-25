package com.firstproject.taskproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproject.taskproject.entity.Users;

public interface UserRepository extends JpaRepository<Users,Long>{
	
	Optional<Users> findByEmail(String email);

	
	
	

}
package com.bach.Commerce.dao;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bach.Commerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Modifying
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String mail);
	
}

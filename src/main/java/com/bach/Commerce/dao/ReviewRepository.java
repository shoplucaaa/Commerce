package com.bach.Commerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bach.Commerce.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	 
}

package com.bach.Commerce.dao;

import java.util.List;
import com.bach.Commerce.entity.Review;

public interface ReviewDAO {
	
	List<Review> getAllReview();
	
	void add(Review review);

	void delete(Review review);

	void edit(Review review);

	Review getById(int id);

	List<Review> find(Integer productId);
	
	Long countById(int id);
}

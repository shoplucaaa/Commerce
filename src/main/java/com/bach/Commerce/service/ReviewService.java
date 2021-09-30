package com.bach.Commerce.service;

import java.util.List;

import com.bach.Commerce.model.ReviewDTO;

public interface ReviewService {
	
	List<ReviewDTO> getAllReview();
	
	void add(ReviewDTO reviewDTO);

	void delete(int id);

	void edit(ReviewDTO reviewDTO);

	ReviewDTO getById(int id);

	List<ReviewDTO> find(int id);
	
	public Long count(int productId);
}

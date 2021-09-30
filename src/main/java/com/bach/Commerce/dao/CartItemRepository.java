package com.bach.Commerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bach.Commerce.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	/* public List<CartItem> findByUser(User user); */
	
	/* public CartItem findByUserAndProduct(User user, Product product); */
	
}

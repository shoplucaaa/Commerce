package com.bach.Commerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bach.Commerce.entity.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}

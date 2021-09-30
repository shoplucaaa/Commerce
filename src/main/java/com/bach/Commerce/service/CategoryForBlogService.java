package com.bach.Commerce.service;

import java.util.List;

import com.bach.Commerce.model.CategoriesForBlogDTO;

public interface CategoryForBlogService  {
	
	public List<CategoriesForBlogDTO> getAllCategoryForBlog();
	
	public CategoriesForBlogDTO getOne(int id);
	
	public void add(CategoriesForBlogDTO catgoriesForBlogDTO);
	
	public void delete(int id);
	
	public void edit(CategoriesForBlogDTO categoriesForBlogDTO);
	
}

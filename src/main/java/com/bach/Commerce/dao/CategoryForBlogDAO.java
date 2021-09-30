package com.bach.Commerce.dao;

import java.util.List;

import com.bach.Commerce.entity.CategoriesForBlog;

public interface CategoryForBlogDAO {

	public List<CategoriesForBlog> getAllCategoryForBlogs();
	
	public CategoriesForBlog getOne(int id);
	
	public void add(CategoriesForBlog categoriesForBlog);
	
	public void delete(CategoriesForBlog categoriesForBlog);
	
	public void edit(CategoriesForBlog categoriesForBlog);
	
}
